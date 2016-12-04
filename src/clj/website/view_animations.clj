(ns website.view-animations
  (:require [garden.def :refer [defstyles]]
            [garden.stylesheet :refer [at-keyframes]]))

;; --- - --- - --- CHANGE --- - --- - ---

(defstyles change
  (at-keyframes "view-change"
                [:from
                 {:opacity 0
                  :color "purple"}]

                [:to
                 {:opacity 1
                  :color "#111"}]))

;; --- - --- - --- ALL --- - --- - ---

(def all
  [change])
