(ns website.navbar-animations
  (:require [website.variables :refer [vendors]]
            [garden.core :refer [css]]
            [garden.stylesheet :refer [at-keyframes]]))

;; --- - --- - --- RADIO WAVES --- - --- - ---

(def radio-waves
  (css vendors
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
                       :height "500px"}])))

;; --- - --- - --- RAINBOW --- - --- - ---

(def navbar-rainbow
  (css vendors
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
                     [:100% {:height "12.5%"}])))

;; --- - --- - --- HOURGLASS --- - --- - ---

(def hourglass
  (css vendors
       (at-keyframes "hourglass"
                     [:0% {:top "48px"
                           :opacity 0.4
                           :width "96px"
                           :left "163px"}]

                     [:50% {:top "120px"
                            :width 0
                            :left "211px"}]

                     [:100% {:top "192px"
                             :opacity 0.05
                             :width "96px"
                             :left "163px"}])))

;; --- - --- - --- HOME --- - --- - ---

(def home
  (css vendors
       (at-keyframes "home"
                     [:from {:background-position "0 0"}]

                     [:to {:background-position "0 -2000px"}])))




;; --- - --- - --- ALL ANIMATIONS --- - --- - ---

(def all
  (str radio-waves navbar-rainbow hourglass home))
