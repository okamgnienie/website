(ns website.styles
  (:require [website.navbar-animations :refer [home work]]
            [website.reset-styles :refer [reset]]
            [website.navbar-styles :refer [styles]]
            [website.main-styles :refer [main]]
            [website.footer-styles :as footer]))

(defn style []
  [:style reset main styles home work footer/styles])
