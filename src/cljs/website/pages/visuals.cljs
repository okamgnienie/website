(ns website.visuals
  (:require [website.message :refer [message]]))

;; ------------------------
;; Work in progress message

(defn work-in-progress-message []
  [message
   "Creation of this section is currently in progress"
   [:span
    "Come back in the near future to see the " [:strong "Visuals"] " page. "
    "It will contain my personal work and all sort of cool things I managed to collect over the Internet."]
   "dark"])

;; ----------------------
;; Visuals page main view

(defn visuals [page-number]
  [:div {:class "view view--visuals"}
   [:div {:class "container"}
    [work-in-progress-message]]])
