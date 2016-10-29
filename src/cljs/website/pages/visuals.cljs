(ns website.visuals
  (:require [website.navbar :as navbar]))

(defn view []
  [:div [:h2 "Welcome to visuals page"]
   (navbar/component)])
