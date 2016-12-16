(ns website.animations
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

(defstyles visuals-progress
  (at-keyframes "visuals-progress"
                [:0%
                 {:width "0%"
                  :left 0}]

                [:65%
                 {:width "100%"
                  :left 0}]

                [:66%
                 {:width "100%"
                  :left "initial"
                  :right 0}]

                [:70%
                 {:width "100%"
                  :right 0}]

                [:100%
                 {:width "0%"
                  :right 0}]))

;; --- - --- - --- ALL --- - --- - ---

(def all
  [change visuals-progress])
