(ns website.navbar-styles
  (:require [garden.core :refer [css]]
            [garden.selectors :refer [defclass defselector ul li a]]
            [website.variables :refer [white-1 gray-1 black-1 main-font]]))

(defclass navbar)
(defclass navbar__item)
(defclass navbar__magic)
(defclass navbar__title)

(defclass navbar__item--home)

(defclass navbar__mobile)

(def navbar-height "50px")

(def styles
  (css [navbar
        {:font-family main-font
         :font-weight 300
         :height navbar-height
         :background-color gray-1
         :width "100%"
         :position "fixed"
         :z-index 2}
        [:ul {:height navbar-height}]
        [navbar__mobile {:display "none"}]]

       [navbar__item
        {:height "inherit"
         :display "inline-block"
         :font-size "20px"
         :cursor "pointer"
         :text-transform "uppercase"
         :position "relative"
         :margin-right "-4px"}
        [:a {:text-decoration "none"
             :color black-1}]]

       [navbar__magic
        {:display "none"}]

       [navbar__title
        {:padding "15px"
         :height navbar-height
         :text-align "center"}]

       ;; - HOME -

       [navbar__item--home {:padding-left 0}
        [navbar__title {:width "58px"}]
        [:&:hover {:animation "home 7s cubic-bezier(0.4, 0, 1, 1) infinite"
                   :transition "padding 4.5s cubic-bezier(0.4, 0, 1, 1) infinite"
                   :background-image "url(/images/home.jpg)"
                   :background-size "89px"
                   :color white-1}
         [navbar__title {:transition "padding-left 0.2s ease-in-out"
                         :padding-left "15px"
                         }
          [:span {:visibility "hidden"
                  :width "0px"
                  :display "inline-block"
                  :transition "all 0.2s ease-in-out"}]]]]))
