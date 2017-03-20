(ns website.contact
  (:require [reagent.core :as r]

            [website.utils :refer [validate-email]]
            [website.social-links :refer [links]]))

(def form-data (r/atom {:email {:value "" :valid nil}
                        :message {:value "" :valid nil}}))

(def icons [{:icon-class "fa fa-3x fa-linkedin"}
            {:icon-class "fa fa-3x fa-facebook"}
            {:icon-class "fa fa-3x fa-github"}
            {:icon-class "fa fa-3x fa-twitter"}
            {:class "contacts__icon--vsco" :label "VSCO"}])

(defn update-email [email]
  (swap! form-data assoc :email {:value email
                                 :valid (validate-email email)}))

(defn update-message [message]
  (swap! form-data assoc :message {:value message
                                   :valid (< 0 (count message))}))

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
     [:input.contact-form__field
      {:placeholder "Email address"
       :required true
       :value (get-in @form-data [:email :value])
       :on-change #(update-email (-> % .-target .-value))
       :class (when (false? (get-in @form-data [:email :valid]))
                "contact-form__field--invalid")}]
     [:textarea.contact-form__field.contact-form__field--message
      {:placeholder "Message"
       :required true
       :on-change #(update-message (-> % .-target .-value))
       :class (when (false? (get-in @form-data [:message :valid]))
                "contact-form__field--invalid")}]
     [:input.contact-form__field
      {:placeholder "2 + 10 + 30 = ?" :required true}]
     [:button.contact-form__send-btn
      {:type "submit"} "send"]]]])
