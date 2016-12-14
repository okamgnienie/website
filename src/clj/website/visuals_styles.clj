(ns website.visuals-styles
  (:require [garden.def :refer [defstyles]]

            [garden.selectors :refer [defclass
                                      hover
                                      input
                                      span
                                      before
                                      iframe
                                      >]]

            [website.variables :refer [white-1
                                       gray-2
                                       gray-3
                                       gray-4
                                       gray-5
                                       red-2
                                       yellow-2]]))

;; --------------
;; Custom classes

(defclass view--visuals)
(defclass visuals-gallery)

;; Searching/Filtering component
(defclass options)

(defclass filter)
(defclass filter__input)
(defclass filter__clear-btn)
(defclass filter__clear-btn--visible)

;; Visual component
(defclass visual)

(defclass visual__title)
(defclass visual__tag)
(defclass visual__tag--active)

(defclass visual__link)
(defclass visual__img)

(defclass visual__embedded-video)

(defclass visuals-pagination)
(defclass visuals-pagination__arrow)
(defclass visuals-pagination__arrow--disabled)

;; ------
;; Styles

(defstyles styles

  ;; --------------
  ;; View container

  [view--visuals {:background-color gray-3}

   ;; ------------------------------------
   ;; Searching/Filtering compinent styles

   [options {:background-color gray-4}]

   [filter {:height "50px"
            :display "flex"}]

   [filter__input filter__clear-btn {:font-size "16px"
                                     :font-weight 300}]

   [filter__input {:margin-bottom 0
                   :border "none"
                   :border-radius 0
                   :background-color "transparent"
                   :border-bottom (str "1px solid " gray-5 " !important")
                   :color white-1
                   :padding 0
                   :margin "8px"
                   :height "34px"
                   :flex-grow 1}]


   [filter__clear-btn {:color gray-2
                       :transition "width 0.3s linear, padding 0.2s linear"
                       :background-color red-2
                       :text-transform "lowercase"
                       :height "50px"
                       :font-weight 300
                       :border-radius 0
                       :border "none"
                       :float "right"
                       :width "100px"
                       :overflow "hidden"
                       :padding 0
                       :cursor "pointer"}]

   [filter__clear-btn--visible {:width 0}]

   ;; ------------------------------
   ;; General visuals gallery styles

   [visuals-gallery
    {:margin-top "50px"}]

   ;; -----------------------
   ;; Visual component styles

   [visual {:width "100%"
            :margin-bottom "50px"
            :background-color gray-4
            :color white-1}]

   [visual__link {:width "100%"
                  :display "block"}]

   [visual__img {:max-width "100%"
                 :display "block"
                 :margin "0 auto"}]

   [visual__title {:padding "16px 8px"
                   :font-size "16px"
                   :font-weight 300
                   :color gray-2}]

   [visual__tag {:color gray-5
                 :margin-left "8px"
                 :transition "color 0.3s ease"
                 :cursor "pointer"}]

   [visual__tag--active (visual__tag hover) {:color yellow-2}]


   [(visual__tag before) {:content "'•'"
                          :margin-right "8px"
                          :color gray-5}]

   [visual__embedded-video {:position "relative"
                            :padding-bottom "56.25%" ; 16:9 ratio
                            :height 0}]

   [(> visual__embedded-video iframe) {:position "absolute"
                                       :top 0
                                       :left 0
                                       :width "100%"
                                       :height "100%"}]

   [visuals-pagination {:text-align "center"
                        :margin-bottom "50px"
                        :color gray-2
                        :font-weight 300}]

   [visuals-pagination__arrow {:cursor "pointer"
                               :display "inline-block"
                               :width "60px"}]

   [visuals-pagination__arrow--disabled {:color "transparent"
                                         :cursor "default"}]

   ])
