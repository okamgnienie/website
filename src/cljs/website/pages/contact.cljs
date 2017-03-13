(ns website.contact
  (:require [website.social-links :refer [links]]))

(def icons [{:icon-class "fa fa-3x fa-linkedin"}
            {:icon-class "fa fa-3x fa-facebook"}
            {:icon-class "fa fa-3x fa-github"}
            {:icon-class "fa fa-3x fa-twitter"}
            {:class "contacts__icon--vsco" :label "VSCO"}])

(defn contact []
  [:div.view.view--contact
   [:div.container
    [:div.contacts

     ;; Social links
     (map (fn [l]
            [:a.contacts__icon {:key (:link l)
                                :class (:class l)
                                :target "_blank"
                                :href (:link l)}
             [:i {:class (:icon-class l)} (:label l)]])
          (map #(merge %1 %2) icons links))]

    [:form.contact-form.article
     [:textarea.contact-form__message
      {:placeholder "You can type here something and"}]
     [:button.contact-form__send-btn
      {:type "submit"} "send it"]]]])
