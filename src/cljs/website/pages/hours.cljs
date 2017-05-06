(ns website.hours
  (:require [website.message :refer [message]]))

(def number-of-images 196)

(defn hours []
  [:div.view.view--hours
   [:div.container
    [:div.hours-gallery
     (map (fn [k]
            [:img.hours-gallery__item
             {:key k :src (str "/images/hours/" k ".jpg")}])
          (range 1 number-of-images))]]])
