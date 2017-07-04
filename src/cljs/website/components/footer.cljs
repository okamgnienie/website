(ns website.components.footer
  (:require [website.social-links :refer [links]]))

(def icons [{:class "footer__link--linkedin"
             :icon-class "fa fa-1x fa-linkedin"}

            {:class "footer__link--facebook"
             :icon-class "fa fa-1x fa-facebook"}

            {:class "footer__link--github"
             :icon-class "fa fa-1x fa-github"}

            {:class "footer__link--twitter"
             :icon-class "fa fa-1x fa-twitter"}

            {:label "VSCO"
             :class "footer__icon--vsco"}])

(defn footer [theme]
  [:footer.footer.container-fluid {:class (str "footer--" theme)}
   [:div.container
    [:div.footer__credits "Przemyslaw Hardyn • 2016 • Geneva"]
    [:div.footer__contact-icons

     ;; Links with font awesome icons
     (map (fn [l]
            [:a.footer__link {:key (:link l)
                              :class (:class l)
                              :target "_blank"
                              :href (:link l)}
             [:i {:class (:icon-class l)} (:label l)]])
          (map #(merge %1 %2) icons links))]]])
