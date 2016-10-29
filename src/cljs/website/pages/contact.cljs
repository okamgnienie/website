(ns website.contact
  (:require [website.navbar :as navbar]))

(defn view []
  [:div [:h2 "Welcome to contact page"]
   (navbar/component)])
