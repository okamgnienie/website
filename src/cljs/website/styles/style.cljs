(ns website.styles
  (:require [website.navbar-animations :refer [home work]]
            [website.reset-styles :refer [reset]]
            [website.navbar-styles :refer [styles]]
            [website.main-styles :refer [main]]))

(defn style []
  [:style reset main styles home work])
