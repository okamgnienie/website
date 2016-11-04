(ns website.navbar-styles
  (:require [garden.core :refer [css]]
            [garden.selectors :refer [defclass defselector ul li a hover after before]]
            [website.variables :refer [white-1 gray-1 black-1 main-font cyan-1 red-1 yellow-1]]))

;; Main
(defclass navbar)
(defclass navbar__mobile)
(defclass navbar__desktop)

;; Menu items
(defclass navbar__item)
(defclass navbar__item--home)
(defclass navbar__item--work)

;; Titles
(defclass navbar__title)
(defclass navbar__title--work)

;; Magic
(defclass navbar__magic)
(defclass navbar__magic--work)

;; States
(defclass navbar__active)

;; Work button related
(defclass navbar__digital-line)
(defclass navbar__digital-line--cyan)
(defclass navbar__digital-line--red)
(defclass navbar__digital-line--yellow)

;; Animations
(defclass navbar__brain-waves)
(defclass navbar__animated-underline)
(defclass navbar__animated-underline--active)

;; Local properties
(def navbar-height "50px")

(def styles
  (css

   ;; - - - MAIN - - -

   [navbar {:font-family main-font
            :font-weight 300
            :height navbar-height
            :background-color gray-1
            :width "100%"
            :position "fixed"
            :z-index 2}]

   [navbar__mobile {:display "none"}]

   [navbar__desktop {:height navbar-height}]

   [navbar__item {:display "inline-block"
                  :font-size "20px"
                  :cursor "pointer"
                  :text-transform "uppercase"
                  :position "relative"
                  :margin-right "-4px"
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
                   :width "100%"}]

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

   ;; - - - WORK - - -

   [navbar__item--home
    [navbar__title {:padding-left 0
                    :width "71px"
                    :transition "background-color 0.2s ease-in-out, width 0.2s ease-in-out, padding-left 0.2s ease-in-out, color 0.2s ease-in-out"}
     [:span {:visibility "visible"
             :display "inline-block"
             :width "27px"
             :transition "width 0.2s ease-in-out, visibility 0.2s ease-in-out"}]]
    [:&:hover {:animation "home 9s cubic-bezier(0.4, 0, 1, 1) infinite"
               :background-image "url(/images/home.jpg)"
               :background-size "88px"
               :color white-1}
     [navbar__title {:transition "background-color 0.2s ease-in-out, width 0.2s ease-in-out, padding-left 0.2s ease-in-out, color 0.2s ease-in-out"
                     :width "88px"
                     :background-color "rgba(0,0,0,0.3)"
                     :padding-left "15px"
                     :color "white"}
      [navbar__animated-underline
       [:&:after {:background-color white-1}]
       [:span {:visibility "hidden"
               :width 0
               :transition "width 0.2s ease-in-out, visibility 0.2s ease-in-out"}]]]]]

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

   [navbar__brain-waves {:position "absolute"
                         :top "0"
                         :left "90px"
                         :height "50px"
                         :width "40px"}]

   [navbar__title--work {:position "relative"
                         :z-index 1}]

   [navbar__item--work {:transition "padding 0.2s ease-in-out"
                        :padding "0 0 0 0"}]

   [(navbar__item--work hover) {:transition "padding 0.2s ease-in-out"
                                :padding "0 30px 0 10px"}]))
