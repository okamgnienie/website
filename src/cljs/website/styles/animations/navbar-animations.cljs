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
                     [:0% {:background-position "0 0"
                           :color "rgba(255,255,255,0.7)"}]

                     [:2.5% {:background-position "0 -50px"
                             :color "rgba(255,255,255,0.7)"}]

                     [:5% {:background-position "0 -100px"
                           :color "rgba(255,255,255,0.7)"}]

                     [:7.5% {:background-position "0 -150px"
                             :color "rgba(255,255,255,0.7)"}]

                     [:10% {:background-position "0 -200px"
                            :color "rgba(255,255,255,0.7)"}]

                     [:12.5% {:background-position "0 -250px"
                              :color "rgba(255,255,255,0.7)"}]

                     [:15% {:background-position "0 -300px"
                            :color "rgba(255,255,255,0.7)"}]

                     [:17.5% {:background-position "0 -350px"
                              :color "rgba(255,255,255,0.7)"}]

                     [:20% {:background-position "0 -400px"
                            :color "rgba(255,255,255,0.7)"}]

                     [:22.5% {:background-position "0 -450px"
                              :color "rgba(255,255,255,0.7)"}]

                     [:25% {:background-position "0 -500px"
                            :color "rgba(255,255,255,0.7)"}]

                     [:27.5% {:background-position "0 -550px"
                              :color "rgba(255,255,255,0.7)"}]

                     [:30% {:background-position "0 -600px"
                            :color "rgba(255,255,255,0.7)"}]

                     [:32.5% {:background-position "0 -650px"
                              :color "rgba(255,255,255,0.7)"}]

                     [:35% {:background-position "0 -700px"
                            :color "rgba(255,255,255,0.7)"}]

                     [:37.5% {:background-position "0 -750px"
                              :color "rgba(255,255,255,0.7)"}]

                     [:40% {:background-position "0 -800px"
                            :color "rgba(255,255,255,0.7)"}]

                     [:42.5% {:background-position "0 -850px"
                              :color "rgba(255,255,255,0.7)"}]

                     [:45% {:background-position "0 -900px"
                            :color "rgba(255,255,255,0.7)"}]

                     [:47.5% {:background-position "0 -950px"
                              :color "rgba(255,255,255,0.7)"}]

                     [:50% {:background-position "0 -1000px"
                            :color "rgba(255,255,255,0.7)"}]

                     [:52.5% {:background-position "0 -1050px"
                              :color "rgba(255,255,255,0.7)"}]

                     [:55% {:background-position "0 -1100px"
                            :color "rgba(255,255,255,0.7)"}]

                     [:57.5% {:background-position "0 -1150px"
                              :color "rgba(255,255,255,0.7)"}]

                     [:60% {:background-position "0 -1200px"
                            :color "rgba(255,255,255,0.7)"}]

                     [:62.5% {:background-position "0 -1250px"
                              :color "rgba(255,255,255,0.7)"}]

                     [:65% {:background-position "0 -1300px"
                            :color "rgba(255,255,255,0.7)"}]

                     [:67.5% {:background-position "0 -1350px"
                              :color "rgba(255,255,255,0.7)"}]

                     [:70% {:background-position "0 -1400px"
                            :color "rgba(255,255,255,0.7)"}]

                     [:72.5% {:background-position "0 -1450px"
                              :color "rgba(255,255,255,0.7)"}]

                     [:75% {:background-position "0 -1500px"
                            :color "rgba(255,255,255,0.7)"}]

                     [:77.5% {:background-position "0 -1550px"
                              :color "rgba(255,255,255,0.7)"}]

                     [:80% {:background-position "0 -1600px"
                            :color "rgba(255,255,255,0.7)"}]

                     [:82.5% {:background-position "0 -1650px"
                              :color "rgba(255,255,255,0.7)"}]

                     [:85% {:background-position "0 -1700px"
                            :color "rgba(255,255,255,0.7)"}]

                     [:87.5% {:background-position "0 -1750px"
                              :color "rgba(255,255,255,0.7)"}]

                     [:90% {:background-position "0 -1800px"
                            :color "rgba(255,255,255,0.7)"}]

                     [:92.5% {:background-position "0 -1850px"
                              :color "rgba(255,255,255,0.7)"}]

                     [:95% {:background-position "0 -1900px"
                            :color "rgba(255,255,255,0.7)"}]

                     [:97.5% {:background-position "0 -1950px"
                              :color "rgba(255,255,255,0.7)"}]

                     [:100% {:background-position "0 -2000px"
                             :color "rgba(255,255,255,0.7)"}])))

;; --- - --- - --- ALL ANIMATIONS --- - --- - ---

(def all
  (str radio-waves navbar-rainbow hourglass home))
