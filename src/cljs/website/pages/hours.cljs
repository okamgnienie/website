(ns website.hours
  (:require [website.message :refer [message]]))

(defn work-in-progress-message []
  [message
   "Creation of this section is currently in progress"
   [:span
    "Come back in the near future to see the " [:strong "Hours"] " project."]
   "bright"])

(defn hours []
  [:div.view.view--hours
   [:div.container
    [work-in-progress-message]]])
