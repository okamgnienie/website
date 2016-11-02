(ns website.main-styles
  (:require [garden.core :refer [css]]
            [garden.selectors :refer [defclass]]
            [website.variables :refer [gray-1 gray-2 main-font]]))

(def main
  (css [:html {:background-color gray-1
               :font-family main-font
               :min-height "100%"}]

       [:body {:background-color gray-2
               :min-height "100%"}]

       [(defclass view) {:margin "0 auto"
                         :padding-top "50px"}]

       [(defclass container) {:max-width "960px"
                              :margin "0 auto"}]

       [(defclass fluid-container) {:width "100%"}]))
