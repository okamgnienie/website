(ns website.mobile-navbar-styles
  (:require [garden.def :refer [defstyles]]
            [garden.stylesheet :refer [at-media]]
            [garden.selectors :refer [defclass after]]
            [website.variables :refer [desktop-min
                                       gray-2
                                       black-2]]))

(defclass mobile-navbar)

(defclass mobile-navbar__menu)
(defclass mobile-navbar__menu--hidden)

(defclass mobile-navbar__menu-list)
(defclass mobile-navbar__menu-btn)
(defclass mobile-navbar__menu-item)
(defclass mobile-navbar__menu-link)

(defstyles styles
  (at-media {:min-width desktop-min}
            [mobile-navbar {:display "none"}])

  [mobile-navbar__menu {:position "absolute"
                        :top "50px"
                        :left 0
                        :width "100%"
                        :overflow "hidden"
                        :height "225px"
                        :transition "height .3s"}]

  [mobile-navbar__menu--hidden {:height 0
                                :transition "height .3s"}]

  [mobile-navbar__menu-list {:position "absolute"
                             :width "100%"
                             :bottom 0
                             :background-color black-2
                             :font-weight 300
                             :padding-top "10px"
                             :padding-bottom "10px"
                             :height "225px"}]

  [mobile-navbar__menu-item {:width "100%"}]

  [mobile-navbar__menu-link {:font-size "20px"
                             :line-height "20px"
                             :font-weight 300
                             :padding "10px 10px"
                             :text-transform "uppercase"
                             :color gray-2
                             :text-decoration "none"
                             :display "inline-block"}]

  [(mobile-navbar__menu-link after) {:background-color gray-2}]

  [mobile-navbar__menu-btn {:position "absolute"
                            :top 0
                            :right "15px"
                            :border "none"
                            :background-color "transparent"
                            :font-size "20px"
                            :line-height "20px"
                            :padding 0
                            :margin 0
                            :font-weight 300
                            :text-align "center"
                            :height "50px"}])
