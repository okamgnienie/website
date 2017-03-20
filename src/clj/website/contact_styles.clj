(ns website.contact-styles
  (:require [garden.def :refer [defstyles]]

            [garden.selectors :refer [i
                                      defclass
                                      hover
                                      defclass
                                      focus
                                      textarea
                                      input]]

            [website.variables :refer [gray-2
                                       red-1
                                       gray-3
                                       blue-2
                                       linkedin-color
                                       facebook-color
                                       github-color
                                       twitter-color]]))
;; --------------
;; Custom classes

(defclass view--contact)

(defclass contacts)
(defclass contacts__icon)
(defclass contacts__icon--vsco)

(defclass contact-form__author)
(defclass contact-form__field)
(defclass contact-form__field--message)
(defclass contact-form__field--invalid)

(defclass contact-form__send-btn)

;; ------
;; Styles

(defstyles styles

  ;; --------------
  ;; View container

  [view--contact

   [contacts {:display "flex"
              :justify-content "space-around"}]

   [contacts__icon {:min-width "40px"
                    :padding "50px 5px"
                    :text-align "center"
                    :color gray-3
                    :text-decoration "none"
                    :font-style "normal"
                    :cursor "default"}
    [i {:transition "color .3s ease"
        :cursor "pointer"}]]

   [contacts__icon--vsco
    [i {:font-size "29px"
        :font-weight 300
        :line-height "50px"
        :font-style "normal"}]
    [(i hover) {:-webkit-background-clip "text"
                :color "transparent !important"
                :transition "none !important"
                :animation "rainbow-text 0.3s infinite"}]]

   [contacts__icon (i hover) {:transition "color 0.3s ease"}
    [:&.fa-linkedin {:color linkedin-color}]
    [:&.fa-facebook {:color facebook-color}]
    [:&.fa-github {:color github-color}]
    [:&.fa-twitter {:color twitter-color}]]

   [contact-form__field {:width "100%"
                         :border-radius 0
                         :display "block"
                         :background-color gray-2
                         :border "none"
                         :resize "none"
                         :padding "10px"
                         :font-size "20px"
                         :font-weight 200}]

   [(focus contact-form__field) {:border-left (str "3px solid " blue-2)
                                 :padding-left "7px"}]

   [(focus contact-form__field--invalid) {:border-left (str "3px solid " red-1)}]

   [contact-form__field--message {:min-height "200px"}]

   [contact-form__field--invalid {:color red-1}]

   [contact-form__send-btn {:background-color blue-2
                            :border-radius 0
                            :border "none"
                            :color gray-2
                            :font-size "20px"
                            :float "right"
                            :font-weight 200
                            :text-transform "capitalize"
                            :padding "10px 30px"
                            :min-width "150px"
                            :margin-top "10px"}]])
