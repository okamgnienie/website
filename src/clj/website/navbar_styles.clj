(ns website.navbar-styles
  (:require [garden.def :refer [defstyles]]
            [garden.stylesheet :refer [at-media]]

            [garden.selectors :refer [defclass
                                      defselector
                                      ul
                                      li
                                      a
                                      hover
                                      after]]

            [website.variables :refer [white-1
                                       gray-1
                                       black-1
                                       main-font
                                       cyan-1
                                       red-1
                                       yellow-1
                                       mobile-max
                                       red-1
                                       orange-1
                                       yellow-1
                                       green-1
                                       cyan-1
                                       blue-1
                                       purple-1
                                       pink-1]]))

;; Main
(defclass navbar)
(defclass navbar__mobile)
(defclass navbar__desktop)

;; Menu items
(defclass navbar__item)
(defclass navbar__item--home)
(defclass navbar__item--work)
(defclass navbar__item--hours)
(defclass navbar__item--visuals)
(defclass navbar__item--contact)

;; Titles
(defclass navbar__title)
(defclass navbar__title--home)
(defclass navbar__title--work)
(defclass navbar__title--hours)
(defclass navbar__title--visuals)
(defclass navbar__title--contact)

;; Magic
(defclass navbar__magic)
(defclass navbar__magic--work)
(defclass navbar__magic--hours)
(defclass navbar__magic--visuals)
(defclass navbar__magic--contact)

;; States
(defclass navbar__active)

;; Work button related
(defclass navbar__digital-line)
(defclass navbar__digital-line--cyan)
(defclass navbar__digital-line--red)
(defclass navbar__digital-line--yellow)

(defclass navbar__digital-line-cover)
(defclass navbar__digital-line-cover--cyan)
(defclass navbar__digital-line-cover--red)
(defclass navbar__digital-line-cover--yellow)

(defclass navbar__digital-line-cover--cyan-1)
(defclass navbar__digital-line-cover--cyan-2)

(defclass navbar__digital-line-cover--red-1)
(defclass navbar__digital-line-cover--red-2)

(defclass navbar__digital-line-cover--yellow-1)
(defclass navbar__digital-line-cover--yellow-2)

;; Hours button specific
(defclass navbar__time)
(defclass navbar__time--active)

;; Visuals button specific
(defclass navbar__rainbow--red)
(defclass navbar__rainbow--orange)
(defclass navbar__rainbow--yellow)
(defclass navbar__rainbow--green)
(defclass navbar__rainbow--cyan)
(defclass navbar__rainbow--blue)
(defclass navbar__rainbow--purple)
(defclass navbar__rainbow--pink)

;; Contact button specific
(defclass navbar__radio-wave)
(defclass navbar__radio-wave--active)

;; Animations
(defclass navbar__brain-waves)
(defclass navbar__animated-underline)
(defclass navbar__animated-underline--active)

;; Local properties
(def navbar-height "50px")

(defstyles styles

  ;; - - - MAIN - - -

  [navbar {:font-family main-font
           :font-weight 300
           :height navbar-height
           :background-color gray-1
           :width "100%"
           :position "fixed"
           :z-index 2}]

  [navbar__mobile {:display "none"}]

  [navbar__desktop {:height navbar-height
                    :position "relative"}]

  [navbar__item {:display "inline-block"
                 :font-size "20px"
                 :cursor "pointer"
                 :text-transform "uppercase"
                 :position "relative"
                 ;; :margin-right "-4px"
                 :height navbar-height}
   [:a {:text-decoration "none"
        :color black-1
        :height "100%"
        :display "block"
        :width "100%"}]]

  [navbar__title {:background-color gray-1
                  :color black-1
                  :padding "15px"
                  :height navbar-height
                  :text-align "center"}]

  [navbar__magic {:display "block"
                  :height "100%"
                  :width "100%"
                  :position "absolute"}]

  ;; - - - ACTIVE - - -

  [navbar__animated-underline {:display "inline-block"
                               :position "relative"
                               :padding-bottom "1px"}
   [:&:after {:content "''"
              :display "block"
              :margin "auto"
              :height "1px"
              :width 0
              :background "transparent"
              :transition "width .5s ease, background-color .5s ease"}]]

  [(navbar__animated-underline--active after) {:width "100%"
                                               :background-color black-1}]

  ;; - - - HOME - - -

  [navbar__title--home {:padding-left 0
                        :width "72px"
                        :transition "background-color 0.2s ease-in-out, width 0.2s ease-in-out, padding-left 0.2s ease-in-out, color 0.2s ease-in-out"}
   [:span {:visibility "visible"
           :display "inline-block"
           :width "27px"
           :transition "width 0.2s ease-in-out, visibility 0.2s ease-in-out"}]]

  ;; Hover

  [(navbar__item--home hover) {:animation "home 10s linear infinite"
                               :background-image "url(/images/home.jpg)"
                               :background-size "88px"
                               :color white-1}
   [navbar__title--home {:transition "background-color 0.2s ease-in-out, width 0.2s ease-in-out, padding-left 0.2s ease-in-out, color 0.2s ease-in-out"
                         :width "88px"
                         :background-color "rgba(0,0,0,0.3)"
                         :padding-left "15px"
                         :color "white"}
    [navbar__animated-underline
     [:&:after {:background-color white-1}]
     [:span {:visibility "hidden"
             :width 0
             :transition "width 0.2s ease-in-out, visibility 0.2s ease-in-out"}]]]]

  ;; Media query

  (at-media {:max-width mobile-max}
            [navbar__title--home {:padding-left "10px"
                                  :width "81px"}])


  ;; - - - WORK - - -

  [navbar__magic--work {:position "absolute"
                        :top 0
                        :left 0
                        :height "50px"
                        :width "100%"
                        :background-color black-1}]

  [navbar__digital-line {:position "absolute"
                         :height "2px"
                         :width "100%"
                         :left 0}]

  [navbar__digital-line--cyan {:top "14px"
                               :background-color cyan-1}]

  [navbar__digital-line--red {:top "25px"
                              :background-color red-1}]

  [navbar__digital-line--yellow {:top "35px"
                                 :background-color yellow-1}]

  [navbar__digital-line-cover {:position "absolute"
                               :background-color black-1
                               :animation "work 0.5s linear infinite"
                               :left "90px"
                               :height "2px"}]

  [navbar__digital-line-cover--cyan {:top "14px"}]
  [navbar__digital-line-cover--cyan-1 {:animation-delay "1s"
                                       :width "7px"}]
  [navbar__digital-line-cover--cyan-2 {:animation-delay "0.3s"
                                       :width "4px"}]

  [navbar__digital-line-cover--red {:top "25px"}]
  [navbar__digital-line-cover--red-1 {:animation-delay "0.25s"
                                      :width "4px"}]
  [navbar__digital-line-cover--red-2 {:width "4px"}]

  [navbar__digital-line-cover--yellow {:top "35px"}]
  [navbar__digital-line-cover--yellow-1 {:animation-delay "1.1s"
                                         :width "4px"}]
  [navbar__digital-line-cover--yellow-2 {:animation-delay "0.45s"
                                         :width "8px"}]

  [navbar__brain-waves {:position "absolute"
                        :top "0"
                        :left "90px"
                        :height "50px"
                        :width "40px"}]

  [navbar__title--work {:position "relative"
                        :width "88px"
                        :z-index 1}]

  [navbar__item--work {:transition "padding 0.2s ease-in-out"
                       :padding "0 0 0 0"}]

  [(navbar__item--work hover) {:transition "padding 0.2s ease-in-out"
                               :padding "0 30px 0 10px"}]

  ;; - - - HOURS - - -

  [navbar__item--hours {:position "initial"}]

  [navbar__time {:position "absolute"
                 :z-index "-1"
                 :display "none"
                 :border-top "black 1px solid"
                 :border-bottom "white 1px solid"}]


  [navbar__time--active {:display "block"
                         :animation "hourglass-1 1.2s linear"
                         :pointer-events "none"
                         :cursor "default"}]

  [navbar__magic--hours {:position "initial"
                         :height 0}]

  [navbar__title--hours {:width "96px"}]

  ;; Media query

  (at-media {:max-width mobile-max}
            [navbar__time--active {:animation "hourglass-2 1.2s linear"}])

  ;; - - - VISUALS - - -

  [navbar__magic--visuals {:overflow "hidden"}]

  [navbar__title--visuals {:margin 0
                           :width "108px"
                           :transition "margin 0.2s ease-in-out"}]

  [navbar__rainbow--red {:background-color red-1
                         :animation "visuals-1 0.5s infinite"}]

  [navbar__rainbow--orange {:background-color orange-1
                            :animation "visuals-2 0.4s infinite"}]

  [navbar__rainbow--yellow {:background-color yellow-1
                            :animation "visuals-3 0.9s infinite"}]

  [navbar__rainbow--green {:background-color green-1
                           :animation "visuals-2 0.4s infinite"}]

  [navbar__rainbow--cyan {:background-color cyan-1
                          :animation "visuals-1 0.6s infinite"}]

  [navbar__rainbow--blue {:background-color blue-1
                          :animation "visuals-3 0.7s infinite"}]

  [navbar__rainbow--purple {:background-color purple-1
                            :animation "visuals-3 0.5s infinite"}]

  [navbar__rainbow--pink {:background-color pink-1
                          :animation "visuals-1 0.3s infinite"}]

  ;; Hover

  [(navbar__item--visuals hover)
   [navbar__title--visuals {:margin "0 3px 0 30px"
                            :transition "margin 0.2s ease-in-out"}]]

  ;; - - - CONTACT - - -

  [navbar__item--contact {:position "initial"}]

  [navbar__title--contact {:background-color "transparent"
                           :width "120px"}]

  [navbar__magic--contact {:position "initial"
                           :height 0}]

  [navbar__radio-wave {:pointer-events "none"
                       :border-radius "50%"
                       :width 0
                       :height 0
                       :position "absolute"
                       :border "1px solid black"
                       :opacity 0
                       :z-index 1}]

  [navbar__radio-wave--active {:animation "radio-wave-1 2.5s linear"}]

  ;; Media query

  (at-media {:max-width mobile-max}
            [navbar__radio-wave--active {:animation "radio-wave-2 2.5s linear"}]))
