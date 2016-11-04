(ns website.navbar
  (:require [garden.core :refer [css]]))

(defn navbar []
  [:div {:class "navbar container-fluid"}

   ;; - - - MOBILE NAVBAR - - -

   [:ul {:class "navbar__mobile"}]

   ;; - - - DESKTOP NAVBAR - - -

   [:ul {:class "navbar__desktop container"}

    ;; - HOME -

    [:li {:class "navbar__item navbar__item--home"}
     [:a {:href "/"}
      [:div {:class "navbar__title"}
       [:div {:class "navbar__animated-underline"}
        [:span "Ho"] "me"]]]]

    ;; - WORK -

    [:li {:class "navbar__item navbar__item--work"}
     [:a {:href "/work"}
      [:div {:class "navbar__magic navbar__magic--work"}
       [:div {:class "navbar__digital-line navbar__digital-line--cyan"}]
       [:div {:class "navbar__digital-line navbar__digital-line--red"}]
       [:div {:class "navbar__digital-line navbar__digital-line--yellow"}]
       [:canvas {:class "navbar__brain-waves" :width "40" :height "50"}]]
      [:div {:class "navbar__title navbar__title--work"}
       [:span "Work"]]]]

    ;; - HOURS -

    [:li {:class "navbar__item navbar__item--hours"}
     [:a {:href "/hours"}
      ;; [:div {:class "navbar__magic"}]
      [:div {:class "navbar__title"}
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
      [:div {:class "navbar__title"}
       [:span "Visuals"]]]]

    ;; - CONTACT -

    [:li {:class "navbar__item navbar__item--contact"}
     [:a {:href "/contact"}
      ;; [:div {:class "navbar__magic"}]
      [:div {:class "navbar__title"}
       [:span "Contact"]]]]]])
