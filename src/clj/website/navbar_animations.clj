(ns website.navbar-animations
  (:require [garden.def :refer [defstyles]]
            [garden.stylesheet :refer [at-keyframes]]))

;; --- - --- - --- RADIO WAVES --- - --- - ---

(defstyles radio-waves
  (at-keyframes "navbar-waves"
                [:from
                 {:top "24px"
                  :left "429px"
                  :opacity 0.5
                  :width 0
                  :height 0}]

                [:to
                 {:top "-225px"
                  :left "180px"
                  :opacity 0
                  :width "500px"
                  :height "500px"}]))

;; --- - --- - --- RAINBOW --- - --- - ---

(defstyles navbar-rainbow
  (at-keyframes "navbar-rainbow-1"
                [:0% {:height "12.5%"}]
                [:33% {:height "25%"}]
                [:66% {:height "5%"}]
                [:100% {:height "12.5%"}])

  (at-keyframes "navbar-rainbow-2"
                [:0% {:height "12.5%"}]
                [:33% {:height "17%"}]
                [:66% {:height "9%"}]
                [:100% {:height "12.5%"}])

  (at-keyframes "navbar-rainbow-3"
                [:0% {:height "12.5%"}]
                [:50% {:height "30%"}]
                [:100% {:height "12.5%"}]))

;; --- - --- - --- HOURGLASS --- - --- - ---

;; For wide screen
(defstyles hourglass-1
  (at-keyframes "hourglass-1"
                [:0% {:top "48px"
                      :opacity 0.4
                      :width "96px"
                      :left "160px"}]

                [:50% {:top "120px"
                       :width 0
                       :left "208px"}]

                [:100% {:top "192px"
                        :opacity 0.05
                        :width "96px"
                        :left "160px"}]))

;; For narrow screen
(defstyles hourglass-2
  (at-keyframes "hourglass-2"
                [:0% {:top "48px"
                      :opacity 0.4
                      :width "96px"
                      :left "170px"}]

                [:50% {:top "120px"
                       :width 0
                       :left "218px"}]

                [:100% {:top "192px"
                        :opacity 0.05
                        :width "96px"
                        :left "170px"}]))

;; --- - --- - --- HOME --- - --- - ---

(defstyles home
  (at-keyframes "home"
                [:from {:background-position "0 0"}]

                [:to {:background-position "0 -2000px"}]))

;; --- - --- - --- WORK --- - --- - ---

(defstyles work
  (at-keyframes "work"
                [:from {:left "90px"}]

                [:to {:left "125px"}]))

;; --- - --- - --- VISUALS --- - --- - ---

(defstyles visuals-1
  (at-keyframes "visuals-1"
                [:0% {:height "12.5%"}]
                [:33% {:height "25%"}]
                [:66% {:height "5%"}]
                [:100% {:height "12.5%"}]))

(defstyles visuals-2
  (at-keyframes "visuals-2"
                [:0% {:height "12.5%"}]
                [:33% {:height "17%"}]
                [:66% {:height "9%"}]
                [:100% {:height "12.5%"}]))

(defstyles visuals-3
  (at-keyframes "visuals-3"
                [:0% {:height "12.5%"}]
                [:50% {:height "30%"}]
                [:100% {:height "12.5%"}]))

;; --- - --- - --- CONTACT --- - --- - ---

;; For wide screen
(defstyles radio-wave-1
  (at-keyframes "radio-wave-1"
                [:from {:top "24px"
                        :left "423px"
                        :opacity 0.5
                        :width 0
                        :height 0}]
                [:to {:top "-226px"
                      :left "173px"
                      :opacity 0
                      :width "500px"
                      :height "500px"}]))

;; For narrow screen
(defstyles radio-wave-2
  (at-keyframes "radio-wave-2"
                [:from {:top "24px"
                        :left "433px"
                        :opacity 0.5
                        :width 0
                        :height 0}]
                [:to {:top "-226px"
                      :left "183px"
                      :opacity 0
                      :width "500px"
                      :height "500px"}]))

;; --- - --- - --- ALL ANIMATIONS --- - --- - ---

(def all
  [radio-waves
   navbar-rainbow
   hourglass-1
   hourglass-2
   home
   work
   visuals-1
   visuals-2
   visuals-3
   radio-wave-1
   radio-wave-2])
