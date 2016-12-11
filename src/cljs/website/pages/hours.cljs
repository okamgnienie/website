(ns website.hours)

(defn hours []
  [:div {:class "view"}
   [:div {:class "container"}
    [:div {:class "hours-gallery"}

     (for [item (range 1 100)]
       [:img {:key item
              :class "hours-gallery__item"
              :src (str "/images/hours/" item ".jpg")}])]]])
