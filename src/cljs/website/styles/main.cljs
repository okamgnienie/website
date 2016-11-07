(ns website.main-styles
  (:require [garden.core :refer [css]]
            [garden.selectors :refer [defclass p]]
            [garden.stylesheet :refer [at-media]]
            [website.variables :refer [gray-1 white-1 main-font]]))

(defclass container)
(defclass fluid-container)

(defclass article)
(defclass article__separator)

(defclass view)

(def main
  (css [:html {:background-color gray-1
               :font-family main-font
               :min-height "100%"}]

       [:body {:background-color white-1
               :min-height "100%"}]

       [:strong {:font-weight "bold"}]

       [article__separator {:display "block"
                            :text-align "center"
                            :margin-bottom "10px"
                            :font-size "20px"}]

       [view {:margin "0 auto"
              :padding-top "50px"}]

       [article {:padding "10px 10px 20px 10px"
                 :text-align "justify"}]


       (at-media {:min-width "961px"}
                 [container {:max-width "960px"
                             :margin "0 auto"}]
                 [article {:padding "0 10px 20px 0"}])

       [fluid-container {:width "100%"}]

       [:p {:margin-bottom "10px"
            :font-size "19px"
            :font-weight "lighter"
            :line-height "25px"}]))
