(ns website.message-styles
  (:require [garden.def :refer [defstyles]]

            [garden.selectors :refer [defclass]]

            [website.variables :refer [gray-2
                                       gray-3
                                       gray-4
                                       gray-5]]))

;; Main
(defclass message)
(defclass message__title)
(defclass message__content)
(defclass message__close-btn)

;; States
(defclass message--hidden)

;; Themes
(defclass message--bright)
(defclass message--dark)

(defstyles styles

  [message {:min-height "50px"
            :position "relative"
            :padding "10px 25px 10px 10px"}]

  [message__title {:font-size "18px"
                   :margin-bottom "10px"}]

  [message__content {:font-size "16px"
                     :line-height "20px"
                     :font-weight 300}]

  [message__close-btn {:position "absolute"
                       :top 0
                       :right 0
                       :border "none"
                       :font-size "16px"
                       :padding "2px 5px"
                       :background-color "transparent"}]

  [message--hidden {:display "none"}]

  ;; Themes
  [message--bright {:background-color gray-2}
   [message__close-btn {:color gray-3}]]

  [message--dark {:background-color gray-4
                  :color gray-5}
   [message__close-btn {:color gray-5}]
   [message__title {:font-weight 300}]])
