(ns website.navbar
  (:require [reagent.core :as r]))

(def path-prefix "#")

(def time-interval (atom nil))
(def radio-interval (atom nil))

(def radio-on (atom false))

(defn get-time-elem []
  (js/document.querySelector
   "div.desktop-navbar__time:not(.desktop-navbar__time--active)"))

(defn animation-finished [elem handler]
  (.addEventListener elem "webkitAnimationEnd" handler)
  (.addEventListener elem "mozAnimationEnd" handler)
  (.addEventListener elem "MSAnimationEnd" handler)
  (.addEventListener elem "oanimationend" handler)
  (.addEventListener elem "animationend" handler))

;; - - - TIME ANIMATION - - -

(defn start-animating-time []
  (reset!
   time-interval
   (js/setInterval
    (fn []
      (let [next-elem (get-time-elem)]
        (when (some? next-elem)
          (set! (.-className next-elem)
                "desktop-navbar__time desktop-navbar__time--active")
          (animation-finished
           next-elem
           (fn []
             (set! (.-className next-elem) "desktop-navbar__time")))))) 120)))

(defn stop-animating-time []
  (.clearInterval js/window @time-interval))

;; - - - RADIO WAVE ANIMATION - - -

(defn get-radio-wave-elem []
  (js/document.querySelector
   ".desktop-navbar__radio-wave:not(.desktop-navbar__radio-wave--active)"))

(defn animate-radio-wave []
  (let [elem (get-radio-wave-elem)]
    (when (some? elem)
      (set! (.-className elem)
            "desktop-navbar__radio-wave desktop-navbar__radio-wave--active")
      (animation-finished
       elem
       (fn []
         (set! (.-className elem) "desktop-navbar__radio-wave"))))))

(defn animate-radio-waves []
  (when @radio-on
    (animate-radio-wave))

  (js/setTimeout #(when @radio-on
                    (animate-radio-wave)) 300)

  (js/setTimeout #(when @radio-on
                    (animate-radio-wave)) 700))

(defn start-animating-radio-waves []
  (reset! radio-on true)
  (animate-radio-waves)
  (reset!
   radio-interval
   (js/setInterval
    (fn []
      (animate-radio-waves)) 3500)))

(defn stop-animating-radio-waves []
  (reset! radio-on false)
  (.clearInterval js/window @radio-interval))

;; -------------------------------------
;; BUTTON COMPONENTS

(def active-button-class
  "navbar__animated-underline--active")

(def work-colors
  ["cyan" "red" "yellow"])

(def visuals-colors
  ["red" "orange" "yellow" "green" "cyan" "blue" "purple" "pink"])

;; - HOME -

(defn home-button [details state-name]
  [:li.desktop-navbar__item.desktop-navbar__item--home
   [:a {:href (str path-prefix (details :path))}
    [:div.desktop-navbar__title.desktop-navbar__title--home
     [:div.navbar__animated-underline
      {:class (when (= state-name (details :title)) active-button-class)}
      [:span "Ho"] "me"]]]])

;; - WORK -

(defn work-button [details state-name]
  [:li.desktop-navbar__item.desktop-navbar__item--work
   [:a {:href (str path-prefix (details :path))}
    [:div.desktop-navbar__magic.desktop-navbar__magic--work
     (map (fn [c] [:div.desktop-navbar__digital-line
                   {:class (str "desktop-navbar__digital-line--" c) :key c}])
          work-colors)
     (map (fn [c]
            (map (fn [i]
                   [:div.desktop-navbar__digital-line-cover
                    {:class (str "desktop-navbar__digital-line-cover--" c
                                 " desktop-navbar__digital-line-cover--" c "-" i)
                     :key (str c "-" i)}])
                 (range 1 3)))
          work-colors)]
    [:div.desktop-navbar__title.desktop-navbar__title--work.navbar__animated-underline
     {:class (when (= state-name (details :title)) active-button-class)}
     [:span (details :title)]]]])

;; - VISUALS -

(defn visuals-button [details state-name]
  [:li.desktop-navbar__item.desktop-navbar__item--visuals
   [:a {:href (str path-prefix (details :path))}
    [:div {:class "desktop-navbar__magic desktop-navbar__magic--visuals"}
     (map (fn [c]
            [:div.desktop-navbar__rainbow
             {:class (str "desktop-navbar__rainbow--" c)
              :key c}]) visuals-colors)]
    [:div.desktop-navbar__title.desktop-navbar__title--visuals.navbar__animated-underline
     {:class (when (= state-name (details :title)) active-button-class)}
     [:span (details :title)]]]])

;; - HOURS -

(defn hours-button [details state-name]
  [:li.desktop-navbar__item.desktop-navbar__item--hours
   {:on-mouse-enter #(start-animating-time)
    :on-mouse-leave #(stop-animating-time)}
   [:a {:href (str path-prefix (details :path))}
    [:div.desktop-navbar__magic.desktop-navbar__magic--hours
     (map (fn [k] [:div.desktop-navbar__time {:key k}]) (range 12))
     [:div.desktop-navbar__title.desktop-navbar__title--hours.navbar__animated-underline
      {:class (when (= state-name (details :title)) active-button-class)}
      [:span (details :title)]]]]])

;; - CONTACT -

(defn contact-button [details state-name]
  [:li.desktop-navbar__item.desktop-navbar__item--contact
   [:a {:href (str path-prefix (details :path))}
    [:div.desktop-navbar__magic.desktop-navbar__magic--contact
     (map (fn [k] [:div.desktop-navbar__radio-wave {:key k}]) (range 8))]
    [:div.desktop-navbar__title.desktop-navbar__title--contact.navbar__animated-underline
     {:class (when (= state-name (details :title)) active-button-class)
      :on-mouse-enter #(start-animating-radio-waves)
      :on-mouse-leave #(stop-animating-radio-waves)}
     [:span (details :title)]]]])

;; -------------------------------------
;; NAVBAR COMPONENT

(def mobile-menu-open (r/atom false))

(def menu-items [{:title "home" :path "/"}
                 {:title "work" :path "/work"}
                 {:title "hours" :path "/hours"}
                 {:title "visuals" :path "/visuals"}
                 {:title "contact" :path "/contact"}])

(defn navbar [state-name]
  [:div.navbar.container-fluid

   ;; - - - MOBILE NAVBAR - - -

   [:div.mobile-navbar
    [:button.mobile-navbar__menu-btn
     {:on-click #(reset! mobile-menu-open true)}
     "MENU"]

    [:div.mobile-navbar__menu
     {:class (str (when (false? @mobile-menu-open)
                    "mobile-navbar__menu--hidden"))}

     [:button.mobile-navbar__menu-btn.mobile-navbar__menu-btn--close
      {:on-click #(reset! mobile-menu-open false)}
      "CLOSE"]

     [:ul.mobile-navbar__menu-list
      (map (fn [item]
             [:li.mobile-navbar__menu-item {:key (item :title)}
              [:a.mobile-navbar__menu-link.navbar__animated-underline
               {:href (str path-prefix (item :path))
                :on-click #(reset! mobile-menu-open false)
                :class (str (when (= state-name (item :title))
                              "navbar__animated-underline--active"))} (item :title)]])
           menu-items)]]]

   ;; - - - DESKTOP NAVBAR - - -

   [:ul.desktop-navbar.container
    [home-button (first menu-items) state-name]
    [work-button (nth menu-items 1) state-name]
    [hours-button (nth menu-items 2) state-name]
    [visuals-button (nth menu-items 3) state-name]
    [contact-button (nth menu-items 4) state-name]]])
