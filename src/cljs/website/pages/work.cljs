(ns website.work
  (:require [website.message :refer [message]]))

(defn work-in-progress-message []
  [message
   "Creation of this section is currently in progress"
   [:span
    "In the near future you'll be able  to view my professional experience, "
    "projects and hackathons I took part under this url."
    [:br]
    "For now please visit my LinkedIn profile "
    [:a {:href "https://linkedin.com/in/phardyn" :target "_blank"} "here"]
    "."]
   "bright"])

(defn work []
  [:div.view.view--work
   [:div.container
    [work-in-progress-message]]])
