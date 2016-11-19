(ns website.footer)

(defn footer []
  [:footer {:class "footer container-fluid"}
   [:div {:class "container"}
    [:div {:class "footer__credits"} "Przemyslaw Hardyn • 2016 • Geneva"]
    [:div {:class "footer__contact-icons"}
     [:a {:class "footer__link footer__link--linkedin" :href "https://linkedin.com/in/phardyn"}
      [:i {:class "fa fa-linkedin fa-1x"}]]

     [:a {:class "footer__link footer__link--facebook" :href "https://facebook.com/przemyslawhardyn"}
      [:i {:class "fa fa-facebook fa-1x"}]]

     [:a {:class "footer__link footer__link--github" :href "https://github.com/phardyn"}
      [:i {:class "fa fa-github fa-1x"}]]

     [:a {:class "footer__link footer__link--twitter" :href "https://t.com/p_hardyn"}
      [:i {:class "fa fa-twitter fa-1x"}]]

     [:a {:class "footer__link footer__link--vsco" :href "https://vsco.co/hardyn"}
      [:i {:class "footer__vsco-icon"} "VSCO"]]]]])
