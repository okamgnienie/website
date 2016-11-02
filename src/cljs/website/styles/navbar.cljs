(ns website.navbar-styles
  (:require [garden.core :refer [css]]
            [garden.selectors :refer [defclass defselector ul li a]]
            [website.variables :refer [gray-1 main-font]]))

(defclass navbar)
(defclass navbar__item)
(defclass navbar__magic)
(defclass navbar__title)

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
         :color "#111"
         :cursor "pointer"
         :text-transform "uppercase"
         :position "relative"
         :margin-right "-4px"}
        [:a {:text-decoration "none"}]]

       [navbar__magic
        {:display "none"}]

       [navbar__title
        {:padding "15px"
         :height navbar-height}]))
