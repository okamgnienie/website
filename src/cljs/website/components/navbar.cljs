(ns website.navbar
  (:require [garden.core :refer [css]]))

(defn navbar [state-name]
  [:div {:class "navbar container-fluid"}

   ;; - - - MOBILE NAVBAR - - -

   [:ul {:class "navbar__mobile"}]

   ;; - - - DESKTOP NAVBAR - - -

   [:ul {:class "navbar__desktop container"}

    ;; - HOME -

    [:li {:class "navbar__item navbar__item--home"}
     [:a {:href "/"}
      [:div {:class "navbar__title navbar__title--home"}
       [:div {:class (str "navbar__animated-underline" (if (= @state-name "home") " navbar__animated-underline--active"))}
        [:span "Ho"] "me"]]]]

    ;; - WORK -

    [:li {:class "navbar__item navbar__item--work"}
     [:a {:href "/work"}
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
      [:div {:class (str "navbar__title navbar__title--work navbar__animated-underline" (if (= @state-name "work") " navbar__animated-underline--active"))}
       [:span "Work"]]]]

    ;; - HOURS -

    [:li {:class "navbar__item navbar__item--hours"}
     [:a {:href "/hours"}
      ;; [:div {:class "navbar__magic"}]
      [:div {:class (str "navbar__title navbar__animated-underline" (if (= @state-name "hours") " navbar__animated-underline--active"))}
       [:span "Hours"]]]]

    ;; - VISUALS -

    [:li {:class "navbar__item navbar__item--visuals"}
     [:a {:href "/visuals"}
      ;; [:div {:class "navbar__magic"}
      ;;  [:div {:class "red"}]
      ;;  [:div {:class "orange"}]
      ;;  [:div {:class "yellow"}]
      ;;  [:div {:class "green"}]
      ;;  [:div {:class "cyan"}]
      ;;  [:div {:class "blue"}]
      ;;  [:div {:class "purple"}]
      ;;  [:div {:class "pink"}]]
      [:div {:class (str "navbar__title navbar__animated-underline" (if (= @state-name "visuals") " navbar__animated-underline--active"))}
       [:span "Visuals"]]]]

    ;; - CONTACT -

    [:li {:class "navbar__item navbar__item--contact"}
     [:a {:href "/contact"}
      ;; [:div {:class "navbar__magic"}]
      [:div {:class (str "navbar__title navbar__animated-underline" (if (= @state-name "contact") " navbar__animated-underline--active"))}
       [:span "Contact"]]]]]])
