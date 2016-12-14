(ns website.contact)

(defn contact []
  [:div {:class "view"}
   [:div {:class "container"}
    [:div {:class "contacts"}

     [:a {:target "_blank"
          :class "contacts__icon"
          :href "https://linkedin.com/in/phardyn"}
      [:i {:class "fa fa-linkedin fa-3x"}]]

     [:a {:target "_blank"
          :class "contacts__icon"
          :href "https://facebook.com/przemyslawhardyn"}
      [:i {:class "fa fa-facebook fa-3x"}]]

     [:a {:target "_blank"
          :class "contacts__icon"
          :href "https://github.com/phardyn"}
      [:i {:class "fa fa-github fa-3x"}]]

     [:a {:target "_blank"
          :class "contacts__icon"
          :href "https://t.com/p_hardyn"}
      [:i {:class "fa fa-twitter fa-3x"}]]

     [:a {:target "_blank"
          :class "contacts__icon contacts__icon--vsco"
          :href "https://vsco.co/hardyn"}
      [:i "VSCO"]]]

    [:form {:class "contact-form"}
     [:textarea {:placeholder "Type here what is on your heart."}]
     [:input {:type "submit" :value "send my message"}]]]])
