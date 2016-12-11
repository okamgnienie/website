(ns website.hours-styles
  (:require [garden.def :refer [defstyles]]

            [garden.stylesheet :refer [at-media]]

            [garden.selectors :refer [defclass]]

            [website.variables :refer [hours-grid-1
                                       hours-grid-2
                                       hours-grid-3
                                       hours-grid-4]]))

;; --------------
;; Custom classes

(defclass hours-gallery)
(defclass hours-gallery__item)

;; ------
;; Styles

(defstyles styles

  [hours-gallery {:column-count 5
                  :column-gap "0px" }]

  (at-media {:max-width hours-grid-4}
            [hours-gallery {:column-count 4}])

  (at-media {:max-width hours-grid-3}
            [hours-gallery {:column-count 3}])

  (at-media {:max-width hours-grid-2}
            [hours-gallery {:column-count 2}])

  (at-media {:max-width hours-grid-1}
            [hours-gallery {:column-count 1}])

  [hours-gallery__item {:display "block"
                        :width "100% !important"
                        :height "auto !important"}])
