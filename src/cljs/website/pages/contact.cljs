(ns website.pages.contact
  (:require [reagent.core :as r]

            [website.utils :refer [validate-email riddles]]
            [website.social-links :refer [links]]))

(def form-data (r/atom {:email {:value "" :valid nil}
                        :message {:value "" :valid nil}
                        :riddle {:value "" :valid nil}}))

(def riddle (rand-nth riddles))

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

(defn update-riddle [answer]
  (swap! form-data assoc :riddle {:value answer
                                  :valid (= (riddle :answer) (int answer))}))

(defn contacts []
  [:div.contacts
   (map (fn [l]
          [:a.contacts__icon {:key (:link l)
                              :class (:class l)
                              :target "_blank"
                              :href (:link l)}
           [:i {:class (:icon-class l)} (:label l)]])
        (map #(merge %1 %2) icons links))])

(defn contact-form []
  [:form.contact-form.article
   [:input.contact-form__field
    {:placeholder "Email address"
     :type "email"
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
    {:placeholder (riddle :question)
     :type "text"
     :required true
     :on-change #(update-riddle (-> % .-target .-value))
     :class (when (false? (get-in @form-data [:riddle :valid]))
              "contact-form__field--invalid")}]
   [:button.contact-form__send-btn
    {:type "submit"} "send"]])

(defn contact []
  [:div.view.view--contact
   [:div.container
    [contacts]
    ;; [contact-form]
    ]])
