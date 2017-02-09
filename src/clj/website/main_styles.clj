(ns website.main-styles
  (:require [garden.def :refer [defstyles]]
            [garden.selectors :refer [defclass p defid attr after]]
            [garden.stylesheet :refer [at-media]]
            [website.variables :refer [gray-1 white-1 main-font desktop-min]]))

(defid app)

(defclass view)

(defclass container)
(defclass container-fluid)

(defclass article)
(defclass article__separator)

(defclass noselect)

(defstyles styles

  [noselect {:user-select "none"}]

  [:html :body app (attr :data-reactroot) {:height "100%"}]

  [:html {:background-color gray-1
          :font-family main-font}]

  [:body {:background-color white-1}]

  [:strong {:font-weight "bold"}]

  [article__separator {:display "block"
                       :text-align "center"
                       :margin-bottom "10px"
                       :font-size "20px"}]

  [view {:margin "0 auto"
         :padding-top "50px"
         :min-height "100%"
         :margin-bottom "-80px"
         :padding-bottom "130px" ; includes 50px padding for content separation
         :background-color white-1}]

  ;; For sticky footer
  [(view after) {:display "block"
                 :content ""
                 :height "80px"}] ; footer height

  [article {:padding "10px 10px 20px 10px"
            :text-align "justify"}]


  (at-media {:min-width desktop-min}
            [container {:max-width "960px"
                        :margin "0 auto"}]
            [article {:padding "0 10px 20px 0"}])

  [container-fluid {:width "100%"}]

  [:p {:margin-bottom "10px"
       :font-size "19px"
       :font-weight "lighter"
       :line-height "25px"}])
