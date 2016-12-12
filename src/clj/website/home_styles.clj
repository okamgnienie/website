(ns website.home-styles
  (:require [garden.def :refer [defstyles]]
            [garden.selectors :refer [defclass before]]
            [website.variables :refer [gray-2 gray-6]]))

;; --------------
;; Custom classes

(defclass view--home)
(defclass landing)
(defclass landing__text)

;; ------
;; Styles

(defstyles styles

  ;; Main view container
  [view--home

   [landing {:background-color gray-2
             :font-weight "300"
             :color gray-6
             :height "400px"
             :margin-bottom "20px"
             :text-align "center"}]

   [(landing before) {:content "''"
                      :display "inline-block"
                      :height "100%"
                      :vertical-align "middle"
                      :margin-right "-0.25em"}]

   [landing__text {:display "inline-block"
                   :vertical-align "middle"
                   :font-size "40px"}]

   ])
