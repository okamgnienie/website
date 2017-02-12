(ns website.desktop-navbar-styles
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
                                       desktop-min
                                       desktop-navbar-min
                                       red-1
                                       orange-1
                                       yellow-1
                                       green-1
                                       cyan-1
                                       blue-1
                                       purple-1
                                       pink-1
                                       navbar-height]]))

;; Root element
(defclass desktop-navbar)

;; Menu items
(defclass desktop-navbar__item)
(defclass desktop-navbar__item--home)
(defclass desktop-navbar__item--work)
(defclass desktop-navbar__item--hours)
(defclass desktop-navbar__item--visuals)
(defclass desktop-navbar__item--contact)

;; Titles
(defclass desktop-navbar__title)
(defclass desktop-navbar__title--home)
(defclass desktop-navbar__title--work)
(defclass desktop-navbar__title--hours)
(defclass desktop-navbar__title--visuals)
(defclass desktop-navbar__title--contact)

;; Magic
(defclass desktop-navbar__magic)
(defclass desktop-navbar__magic--work)
(defclass desktop-navbar__magic--hours)
(defclass desktop-navbar__magic--visuals)
(defclass desktop-navbar__magic--contact)

;; States
(defclass desktop-navbar__active)

;; Work button related
(defclass desktop-navbar__digital-line)
(defclass desktop-navbar__digital-line--cyan)
(defclass desktop-navbar__digital-line--red)
(defclass desktop-navbar__digital-line--yellow)

(defclass desktop-navbar__digital-line-cover)
(defclass desktop-navbar__digital-line-cover--cyan)
(defclass desktop-navbar__digital-line-cover--red)
(defclass desktop-navbar__digital-line-cover--yellow)

(defclass desktop-navbar__digital-line-cover--cyan-1)
(defclass desktop-navbar__digital-line-cover--cyan-2)

(defclass desktop-navbar__digital-line-cover--red-1)
(defclass desktop-navbar__digital-line-cover--red-2)

(defclass desktop-navbar__digital-line-cover--yellow-1)
(defclass desktop-navbar__digital-line-cover--yellow-2)

;; Hours button specific
(defclass desktop-navbar__time)
(defclass desktop-navbar__time--active)

;; Visuals button specific
(defclass desktop-navbar__rainbow--red)
(defclass desktop-navbar__rainbow--orange)
(defclass desktop-navbar__rainbow--yellow)
(defclass desktop-navbar__rainbow--green)
(defclass desktop-navbar__rainbow--cyan)
(defclass desktop-navbar__rainbow--blue)
(defclass desktop-navbar__rainbow--purple)
(defclass desktop-navbar__rainbow--pink)

;; Contact button specific
(defclass desktop-navbar__radio-wave)
(defclass desktop-navbar__radio-wave--active)

;; Animations
(defclass desktop-navbar__brain-waves)

;; External classes that have been extended here
(defclass navbar__animated-underline)

(defstyles styles

  [desktop-navbar {:height navbar-height
                   :position "relative"}]

  [desktop-navbar__item {:display "inline-block"
                         :font-size "20px"
                         :cursor "pointer"
                         :text-transform "uppercase"
                         :position "relative"
                         :height navbar-height}
   [:a {:text-decoration "none"
        :color black-1
        :height "100%"
        :display "block"
        :width "100%"}]]

  [desktop-navbar__title {:background-color gray-1
                          :color black-1
                          :padding "15px"
                          :height navbar-height
                          :text-align "center"}]

  [desktop-navbar__magic {:display "block"
                          :height "100%"
                          :width "100%"
                          :position "absolute"}]

  ;; - - - HOME - - -

  [desktop-navbar__title--home {:padding-left 0
                                :width "72px"
                                :transition "background-color 0.2s ease-in-out, width 0.2s ease-in-out, padding-left 0.2s ease-in-out, color 0.2s ease-in-out"}
   [:span {:visibility "visible"
           :display "inline-block"
           :width "27px"
           :transition "width 0.2s ease-in-out, visibility 0.2s ease-in-out"}]]

  ;; Hover

  [(desktop-navbar__item--home hover) {:animation "home 10s linear infinite"
                                       :background-image "url(/images/home.jpg)"
                                       :background-size "88px"
                                       :color white-1}
   [desktop-navbar__title--home {:transition "background-color 0.2s ease-in-out, width 0.2s ease-in-out, padding-left 0.2s ease-in-out, color 0.2s ease-in-out"
                                 :width "88px"
                                 :background-color "rgba(0,0,0,0.3)"
                                 :padding-left "15px"
                                 :color "white"}
    [navbar__animated-underline
     [:&:after {:background-color white-1}]
     [:span {:visibility "hidden"
             :width 0
             :transition "width 0.2s ease-in-out, visibility 0.2s ease-in-out"}]]]]

  ;; - - - WORK - - -

  [desktop-navbar__magic--work {:position "absolute"
                                :top 0
                                :left 0
                                :height "50px"
                                :width "100%"
                                :background-color black-1}]

  [desktop-navbar__digital-line {:position "absolute"
                                 :height "2px"
                                 :width "100%"
                                 :left 0}]

  [desktop-navbar__digital-line--cyan {:top "14px"
                                       :background-color cyan-1}]

  [desktop-navbar__digital-line--red {:top "25px"
                                      :background-color red-1}]

  [desktop-navbar__digital-line--yellow {:top "35px"
                                         :background-color yellow-1}]

  [desktop-navbar__digital-line-cover {:position "absolute"
                                       :background-color black-1
                                       :animation "work 0.5s linear infinite"
                                       :left "90px"
                                       :height "2px"}]

  [desktop-navbar__digital-line-cover--cyan {:top "14px"}]
  [desktop-navbar__digital-line-cover--cyan-1 {:animation-delay "1s"
                                               :width "7px"}]
  [desktop-navbar__digital-line-cover--cyan-2 {:animation-delay "0.3s"
                                               :width "4px"}]

  [desktop-navbar__digital-line-cover--red {:top "25px"}]
  [desktop-navbar__digital-line-cover--red-1 {:animation-delay "0.25s"
                                              :width "4px"}]
  [desktop-navbar__digital-line-cover--red-2 {:width "4px"}]

  [desktop-navbar__digital-line-cover--yellow {:top "35px"}]
  [desktop-navbar__digital-line-cover--yellow-1 {:animation-delay "1.1s"
                                                 :width "4px"}]
  [desktop-navbar__digital-line-cover--yellow-2 {:animation-delay "0.45s"
                                                 :width "8px"}]

  [desktop-navbar__brain-waves {:position "absolute"
                                :top "0"
                                :left "90px"
                                :height "50px"
                                :width "40px"}]

  [desktop-navbar__title--work {:position "relative"
                                :width "88px"
                                :z-index 1}]

  [desktop-navbar__item--work {:transition "padding 0.2s ease-in-out"
                               :padding "0 0 0 0"}]

  [(desktop-navbar__item--work hover) {:transition "padding 0.2s ease-in-out"
                                       :padding "0 30px 0 10px"}]

  ;; - - - HOURS - - -

  [desktop-navbar__item--hours {:position "initial"}]

  [desktop-navbar__time {:position "absolute"
                         :z-index "-1"
                         :display "none"
                         :border-top "black 1px solid"
                         :border-bottom "white 1px solid"}]


  [desktop-navbar__time--active {:display "block"
                                 :animation "hourglass-1 1.2s linear"
                                 :pointer-events "none"
                                 :cursor "default"}]

  [desktop-navbar__magic--hours {:position "initial"
                                 :height 0}]

  [desktop-navbar__title--hours {:width "96px"}]

  ;; - - - VISUALS - - -

  [desktop-navbar__magic--visuals {:overflow "hidden"}]

  [desktop-navbar__title--visuals {:margin 0
                                   :width "108px"
                                   :transition "margin 0.2s ease-in-out"}]

  [desktop-navbar__rainbow--red {:background-color red-1
                                 :animation "visuals-1 0.5s infinite"}]

  [desktop-navbar__rainbow--orange {:background-color orange-1
                                    :animation "visuals-2 0.4s infinite"}]

  [desktop-navbar__rainbow--yellow {:background-color yellow-1
                                    :animation "visuals-3 0.9s infinite"}]

  [desktop-navbar__rainbow--green {:background-color green-1
                                   :animation "visuals-2 0.4s infinite"}]

  [desktop-navbar__rainbow--cyan {:background-color cyan-1
                                  :animation "visuals-1 0.6s infinite"}]

  [desktop-navbar__rainbow--blue {:background-color blue-1
                                  :animation "visuals-3 0.7s infinite"}]

  [desktop-navbar__rainbow--purple {:background-color purple-1
                                    :animation "visuals-3 0.5s infinite"}]

  [desktop-navbar__rainbow--pink {:background-color pink-1
                                  :height "50px"}]

  ;; Hover

  [(desktop-navbar__item--visuals hover)
   [desktop-navbar__title--visuals {:margin "0 3px 0 30px"
                                    :transition "margin 0.2s ease-in-out"}]]

  ;; - - - CONTACT - - -

  [desktop-navbar__item--contact {:position "initial"}]

  [desktop-navbar__title--contact {:background-color "transparent"
                                   :width "120px"}]

  [desktop-navbar__magic--contact {:position "initial"
                                   :height 0}]

  [desktop-navbar__radio-wave {:pointer-events "none"
                               :border-radius "50%"
                               :width 0
                               :height 0
                               :position "absolute"
                               :border "1px solid black"
                               :opacity 0
                               :z-index 1}]

  [desktop-navbar__radio-wave--active {:animation "radio-wave-1 2.5s linear"}]

  ;; - - - MEDIA QUERIES - - -

  (at-media {:max-width desktop-navbar-min}
            [desktop-navbar {:display "none"}])

  (at-media {:max-width desktop-min}
            [desktop-navbar__radio-wave--active {:animation "radio-wave-2 2.5s linear"}])

  (at-media {:max-width desktop-min}
            [desktop-navbar__time--active {:animation "hourglass-2 1.2s linear"}])

  (at-media {:max-width desktop-min}
            [desktop-navbar__title--home {:padding-left "10px"
                                          :width "81px"}]))
