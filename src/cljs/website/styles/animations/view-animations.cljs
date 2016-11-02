(ns website.view-animations
  (:require [website.variables :refer [vendors]]
            [garden.core :refer [css]]
            [garden.stylesheet :refer [at-keyframes]]))

;; --- - --- - --- CHANGE --- - --- - ---

(def change
  (css vendors
       (at-keyframes "view-change"
                     [:from
                      {:opacity 0
                       :color "purple"}]

                     [:to
                      {:opacity 1
                       :color "#111"}])))

;; --- - --- - --- ALL --- - --- - ---

(def all
  (str change))
