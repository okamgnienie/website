(ns website.hours)

(defn hours []
  [:div.view.view--hours
   [:div.container
    [:div.hours-gallery

     (map (fn [k]
            [:img.hours-gallery__item {:key k
                                       :src (str "/images/hours/" k ".jpg")}])
          (range 1 100))]]])
