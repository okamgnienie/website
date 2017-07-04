(ns website.app
  (:require-macros [secretary.core :refer [defroute]])
  (:import goog.History)
  (:require [secretary.core :as secretary]
            [goog.events :as events]
            [goog.history.EventType :as EventType]
            [reagent.core :as r]
            [clojure.string :refer [blank? split]]

            [website.pages.home :refer [home]]
            [website.pages.work :refer [work]]
            [website.pages.hours :refer [hours]]
            [website.pages.visuals :refer [visuals]]
            [website.pages.contact :refer [contact]]

            [website.components.navbar :refer [navbar]]
            [website.components.footer :refer [footer]]))


;; -------------------------
;; Application state atom

(def app-state (r/atom {}))

;; -------------------------
;; Browser history

(defn hook-browser-navigation! []
  (doto (History.)
    (events/listen
     EventType/NAVIGATE
     (fn [event]
       (secretary/dispatch! (.-token event))))
    (.setEnabled true)))

;; -------------------------
;; Initialize application routes

(defn app-routes []
  (secretary/set-config! :prefix "#")

  (defroute "/" []
    (swap! app-state assoc :name "home")
    (swap! app-state assoc :page :home))

  (defroute "/work" []
    (swap! app-state assoc :name "work")
    (swap! app-state assoc :page :work))

  (defroute "/hours" []
    (swap! app-state assoc :name "hours")
    (swap! app-state assoc :page :hours))

  (defroute "/visuals" []
    (swap! app-state assoc :name "visuals")
    (swap! app-state assoc :page :visuals)
    (swap! app-state assoc :page-number 1))

  (defroute "/visuals/:page" [page]
    (swap! app-state assoc :name "visuals")
    (swap! app-state assoc :page :visuals)
    (swap! app-state assoc :page-number (int page)))

  (defroute "/contact" []
    (swap! app-state assoc :name "contact")
    (swap! app-state assoc :page :contact))

  (hook-browser-navigation!))

;; -------------------------
;; Routes

(defmulti current-page #(@app-state :page))
(defmethod current-page :home []
  [:div
   [navbar (@app-state :name)]
   [home]
   [footer "bright"]])
(defmethod current-page :work []
  [:div
   [navbar (@app-state :name)]
   [work]
   [footer "bright"]])
(defmethod current-page :hours []
  [:div
   [navbar (@app-state :name)]
   [hours]
   [footer "bright"]])
(defmethod current-page :visuals []
  [:div
   [navbar (@app-state :name)]
   [visuals (@app-state :page-number)]
   [footer "dark"]])
(defmethod current-page :contact []
  [:div
   [navbar (@app-state :name)]
   [contact]
   [footer "bright"]])
(defmethod current-page :default []
  [:div "Error 404!"])

;; -------------------------
;; Initialize app

(defn get-view-name []
  (let [hash (aget js/location "hash")]
    (if (blank? hash)
      "home"
      (second (split hash #"/")))))

(defn mount-root []
  (swap! app-state assoc :name (get-view-name))
  (swap! app-state assoc :page (keyword (get-view-name)))

  (r/render [current-page] (.getElementById js/document "app")))

(defn init []
  (app-routes)
  (mount-root))
