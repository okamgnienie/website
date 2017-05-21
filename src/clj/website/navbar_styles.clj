(ns website.navbar-styles
  (:require [garden.def :refer [defstyles]]
            [garden.selectors :refer [defclass after]]
            [website.variables :refer [gray-1
                                       main-font
                                       navbar-height
                                       black-1]]))

(defclass navbar)

(defclass navbar__animated-underline)
(defclass navbar__animated-underline--active)

(defstyles styles

  ;; - - - NAVBAR CONTAINER - - -

  [navbar {:font-family main-font
           :font-weight 300
           :height navbar-height
           :background-color gray-1
           :width "100%"
           :position "fixed"
           :z-index 2}]

  ;; - - - ACTIVE NAVBAR ITEM - - -

  [navbar__animated-underline {:display "inline-block"
                               :position "relative"
                               :padding-bottom "1px"}
   [:&:after {:content "''"
              :display "block"
              :margin "auto"
              :height "1px"
              :width 0
              :background "transparent"
              :transition "width .5s ease, background-color .5s ease"}]]

  [(navbar__animated-underline--active after) {:width "100%"
                                               :background-color black-1}]
  )
