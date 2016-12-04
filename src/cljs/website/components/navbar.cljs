(ns website.navbar)

(def time-interval (atom nil))
(def radio-interval (atom nil))

(def radio-on (atom false))

(defn get-time-elem []
  (js/document.querySelector "div.navbar__time:not(.navbar__time--active)"))

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
          (set! (.-className next-elem) "navbar__time navbar__time--active")
          (animation-finished
           next-elem
           (fn []
             (set! (.-className next-elem) "navbar__time")))))) 120)))

(defn stop-animating-time []
  (.clearInterval js/window @time-interval))

;; - - - RADIO WAVE ANIMATION - - -

(defn get-radio-wave-elem []
  (js/document.querySelector ".navbar__radio-wave:not(.navbar__radio-wave--active)"))

(defn animate-radio-wave []
  (let [elem (get-radio-wave-elem)]
    (when (some? elem)
      (set! (.-className elem) "navbar__radio-wave navbar__radio-wave--active")
      (animation-finished
       elem
       (fn []
         (set! (.-className elem) "navbar__radio-wave"))))))

(defn animate-radio-waves []
  (if @radio-on
    (animate-radio-wave))

  (js/setTimeout (fn []
                   (if @radio-on
                     (animate-radio-wave))) 300)

  (js/setTimeout (fn []
                   (if @radio-on
                     (animate-radio-wave))) 700))

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


(defn navbar [state-name]
  [:div {:class "navbar container-fluid"}

   ;; - - - MOBILE NAVBAR - - -

   [:ul {:class "navbar__mobile"}]

   ;; - - - DESKTOP NAVBAR - - -

   [:ul {:class "navbar__desktop container"}

    ;; - HOME -

    [:li {:class "navbar__item navbar__item--home"}
     [:a {:href "#/"}
      [:div {:class "navbar__title navbar__title--home"}
       [:div {:class (str "navbar__animated-underline" (if (= (state-name) "home") " navbar__animated-underline--active"))}
        [:span "Ho"] "me"]]]]

    ;; - WORK -

    [:li {:class "navbar__item navbar__item--work"}
     [:a {:href "#/work"}
      [:div {:class "navbar__magic navbar__magic--work"}
       [:div {:class "navbar__digital-line navbar__digital-line--cyan"}]
       [:div {:class "navbar__digital-line navbar__digital-line--red"}]
       [:div {:class "navbar__digital-line navbar__digital-line--yellow"}]

       [:div {:class "navbar__digital-line-cover navbar__digital-line-cover--cyan navbar__digital-line-cover--cyan-1"}]
       [:div {:class "navbar__digital-line-cover navbar__digital-line-cover--cyan navbar__digital-line-cover--cyan-2"}]

       [:div {:class "navbar__digital-line-cover navbar__digital-line-cover--red navbar__digital-line-cover--red-1"}]
       [:div {:class "navbar__digital-line-cover navbar__digital-line-cover--red navbar__digital-line-cover--red-2"}]

       [:div {:class "navbar__digital-line-cover navbar__digital-line-cover--yellow navbar__digital-line-cover--yellow-1"}]
       [:div {:class "navbar__digital-line-cover navbar__digital-line-cover--yellow navbar__digital-line-cover--yellow-2"}]]
      [:div {:class (str "navbar__title navbar__title--work navbar__animated-underline" (if (= (state-name) "work") " navbar__animated-underline--active"))}
       [:span "Work"]]]]

    ;; - HOURS -

    [:li {:class "navbar__item navbar__item--hours"
          :on-mouse-enter #(start-animating-time)
          :on-mouse-leave #(stop-animating-time)}
     [:a {:href "#/hours"}
      [:div {:class "navbar__magic navbar__magic--hours"}
       [:div {:class "navbar__time"}]
       [:div {:class "navbar__time"}]
       [:div {:class "navbar__time"}]
       [:div {:class "navbar__time"}]
       [:div {:class "navbar__time"}]
       [:div {:class "navbar__time"}]
       [:div {:class "navbar__time"}]
       [:div {:class "navbar__time"}]
       [:div {:class "navbar__time"}]
       [:div {:class "navbar__time"}]
       [:div {:class "navbar__time"}]
       [:div {:class "navbar__time"}]]
      [:div {:class (str "navbar__title navbar__title--hours navbar__animated-underline" (if (= (state-name) "hours") " navbar__animated-underline--active"))}
       [:span "Hours"]]]]

    ;; - VISUALS -

    [:li {:class "navbar__item navbar__item--visuals"}
     [:a {:href "#/visuals"}
      [:div {:class "navbar__magic navbar__magic--visuals"}
       [:div {:class "navbar__rainbow navbar__rainbow--red"}]
       [:div {:class "navbar__rainbow navbar__rainbow--orange"}]
       [:div {:class "navbar__rainbow navbar__rainbow--yellow"}]
       [:div {:class "navbar__rainbow navbar__rainbow--green"}]
       [:div {:class "navbar__rainbow navbar__rainbow--cyan"}]
       [:div {:class "navbar__rainbow navbar__rainbow--blue"}]
       [:div {:class "navbar__rainbow navbar__rainbow--purple"}]
       [:div {:class "navbar__rainbow navbar__rainbow--pink"}]]
      [:div {:class (str "navbar__title navbar__title--visuals navbar__animated-underline" (if (= (state-name) "visuals") " navbar__animated-underline--active"))}
       [:span "Visuals"]]]]

    ;; - CONTACT -

    [:li {:class "navbar__item navbar__item--contact"}
     [:a {:href "#/contact"}
      [:div {:class "navbar__magic navbar__magic--contact"}
       [:div {:class "navbar__radio-wave"}]
       [:div {:class "navbar__radio-wave"}]
       [:div {:class "navbar__radio-wave"}]
       [:div {:class "navbar__radio-wave"}]
       [:div {:class "navbar__radio-wave"}]
       [:div {:class "navbar__radio-wave"}]
       [:div {:class "navbar__radio-wave"}]
       [:div {:class "navbar__radio-wave"}]]
      [:div {:class (str "navbar__title navbar__title--contact navbar__animated-underline" (if (= (state-name) "contact") " navbar__animated-underline--active"))
             :on-mouse-enter #(start-animating-radio-waves)
             :on-mouse-leave #(stop-animating-radio-waves)}
       [:span "Contact"]]]]]])
