(ns website.animations
  (:require [garden.def :refer [defstyles]]
            [garden.stylesheet :refer [at-keyframes]]
            [garden.selectors :refer [defclass]]
            [clojure.string :refer [join]]
            [website.variables :refer [red-3 white-1 black-1]]))

;; -----------------
;; CHANGE ANIMAATION

(defstyles change
  (at-keyframes "view-change"
                [:from
                 {:opacity 0
                  :color "purple"}]

                [:to
                 {:opacity 1
                  :color "#111"}]))

;; --------------------------
;; VISUAL PROGRESS ANIMAATION

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

;; ------------------------------------------------
;; REVOLVE ANIMATION
;;
;; Require using class .revolve on animated element
;; Position of the parent has to be set to relative

(defclass revolve)

(let [color red-3 ; shadow color
      unit "px " ; shadow unit (with spacing)
      length 8] ; shadow length

  (defstyles revolve

    [revolve {:opacity 0
              :transform (str "translate3d(calc(-50% - " length unit "), calc(-50% + " length unit "), 0)")
              :animation "revolve 2s cubic-bezier(0.47, 0.01, 0, 1.01) forwards 0.5s"
              :text-transform "uppercase"
              :margin-left "0.1em"
              :letter-spacing "0.2em"
              :top "50%"
              :left "50%"
              :position "absolute"
              :color black-1
              :display "inline-block"
              :vertical-align "middle"}]

    (at-keyframes "revolve"
                  [:to
                   {:opacity 1
                    :transform "translate3d(-50%, -55%, 0)"
                    :text-shadow (->> (range 1 length)
                                      (map #(str "-" % unit
                                                 % unit
                                                 color
                                                 (when (< % (dec length)) ",")))
                                      (join))}])))

;; --------------
;; ALL ANIMATIONS

(def all
  [change visuals-progress revolve])
