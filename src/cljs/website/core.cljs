(ns website.core
    (:require [reagent.core :as reagent :refer [atom]]
              [reagent.session :as session]

              [website.home :as home]
              [website.work :as work]
              [website.hours :as hours]
              [website.visuals :as visuals]
              [website.contact :as contact]

              [secretary.core :as secretary :include-macros true]
              [accountant.core :as accountant]))

;; -------------------------
;; Views

(defn current-page []
  [:div [(session/get :current-page)]])

;; -------------------------
;; Routes

(secretary/defroute "/" []
  (session/put! :current-page #'home/view))

(secretary/defroute "/work" []
  (session/put! :current-page #'work/view))

(secretary/defroute "/hours" []
  (session/put! :current-page #'hours/view))

(secretary/defroute "/visuals" []
  (session/put! :current-page #'visuals/view))

(secretary/defroute "/contact" []
  (session/put! :current-page #'contact/view))

;; -------------------------
;; Initialize app

(defn mount-root []
  (reagent/render [current-page] (.getElementById js/document "app")))

(defn init! []
  (accountant/configure-navigation!
    {:nav-handler
     (fn [path]
       (secretary/dispatch! path))
     :path-exists?
     (fn [path]
       (secretary/locate-route path))})
  (accountant/dispatch-current!)
  (mount-root))
