(ns website.css
  (:require [website.reset-styles :refer [reset]]
            [website.navbar-animations :as navbar-animations]
            [website.animations :as animations]
            [website.navbar-styles :as navbar]
            [website.mobile-navbar-styles :as mobile-navbar]
            [website.desktop-navbar-styles :as desktop-navbar]
            [website.main-styles :as main]
            [website.footer-styles :as footer]
            [website.visuals-styles :as visuals]
            [website.home-styles :as home]
            [website.hours-styles :as hours]
            [website.contact-styles :as contact]
            [website.rainbow-text :refer [rainbow-text]]))

(def styles
  [reset
   animations/all
   navbar-animations/all
   navbar/styles
   mobile-navbar/styles
   desktop-navbar/styles
   main/styles
   footer/styles
   home/styles
   visuals/styles
   hours/styles
   contact/styles
   rainbow-text])
