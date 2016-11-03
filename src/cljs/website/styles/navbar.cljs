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

(defclass navbar__active)
(defclass navbar__animated-underline)

(def navbar-height "50px")

(def styles
  (css [navbar {:font-family main-font
                :font-weight 300
                :height navbar-height
                :background-color gray-1
                :width "100%"
                :position "fixed"
                :z-index 2}
        [:ul {:height navbar-height}]
        [navbar__mobile {:display "none"}]]

       [navbar__item {:height "inherit"
                      :display "inline-block"
                      :font-size "20px"
                      :cursor "pointer"
                      :text-transform "uppercase"
                      :position "relative"
                      :margin-right "-4px"}
        [:a {:text-decoration "none"
             :color black-1}]
        [navbar__active navbar__animated-underline {:width "100%"
                                                    :background-color "#111"}]]

       [navbar__magic {:display "none"}]

       [navbar__title {:padding "15px"
                       :height navbar-height
                       :text-align "center"}]

       [navbar__animated-underline {:display "inline-block"
                                    :position "relative"
                                    :padding-bottom "1px"}
        [:&:after {:content "''"
                   :display "block"
                   :margin "auto"
                   :height "1px"
                   :width "0px"
                   :background "transparent"
                   :transition "width .5s ease, background-color .5s ease"}]
        [:&.active {:width "100%"
                    :background-color "#111"}]]

       ;; - HOME -

       [navbar__item--home
        [navbar__title {:padding-left 0
                        :transition "padding-left 0.2s ease-in-out"}
         [navbar__animated-underline {:width "60px"}]]
        [:&:hover {:animation "home 9s cubic-bezier(0.4, 0, 1, 1) infinite"
                   :background-image "url(/images/home.jpg)"
                   :background-size "89px"
                   :color white-1}
         [navbar__title {:transition "padding-left 0.2s ease-in-out"
                         :padding-left "15px"}
          [:span {:visibility "hidden"
                  :width 0
                  :display "inline-block"
                  :transition "all 0.2s ease-in-out"}]]]]))
