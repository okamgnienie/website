(ns website.home-styles
  (:require [garden.def :refer [defstyles]]
            [garden.stylesheet :refer [at-media]]
            [garden.selectors :refer [defclass]]
            [website.variables :refer [gray-2 desktop-navbar-min desktop-min]]))

;; --------------
;; Custom classes

(defclass view--home)
(defclass landing)
(defclass landing__text)

;; ------
;; Styles

(defstyles styles

  ;; --------------
  ;; View container

  [view--home

   [landing {:background-color gray-2
             :font-weight "300"
             :height "400px"
             :margin-bottom "20px"
             :position "relative"}]

   [landing__text {:font-size "9em"
                   :font-family "'Montserrat', sans-serif"}]

   (at-media {:max-width desktop-min}
             [landing__text {:font-size "6em"}])

   (at-media {:max-width desktop-navbar-min}
             [landing__text {:font-size "3.5em"}])])
