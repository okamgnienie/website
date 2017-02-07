(ns website.contact)

(def links
  [{:link "https://linkedin.com/in/phardyn"
    :class "fa-linkedin"}

   {:link "https://facebook.com/przemyslawhardyn"
    :class "fa-facebook"}

   {:link "https://github.com/phardyn"
    :class "fa-github"}

   {:link "https://t.com/p_hardyn"
    :class "fa-twitter"}])

(defn contact []
  [:div.view.view--contact
   [:div.container
    [:div.contacts

     ;; Links with font awesome icons
     (map (fn [l]
            [:a.contacts__icon {:key (:class l)
                                :target "_blank"
                                :href (:link l)}
             [:i.fa.fa-3x {:class (:class l)}]])
          links)

     ;; Links with custom icons
     [:a.contacts__icon.contacts__icon--vsco {:target "_blank"
                                              :href "https://vsco.co/hardyn"}
      [:i "VSCO"]]]

    [:form.contact-form
     [:textarea {:placeholder "Type here what is on your heart."}]
     [:input {:type "submit" :value "send my message"}]]]])
