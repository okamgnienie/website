(ns website.reset-styles
  (:require [garden.core :refer [css]]
            [garden.selectors :refer [blockquote q before after]]))

;; --- - --- - --- RESET STYLES --- - --- - ---

(def reset
  (css [:html :body :div :span :applet :object :iframe
        :h1 :h2 :h3 :h4 :h5 :h6 :p :blockquote :pre :a
        :abbr :acronym :address :big :cite :code :del
        :dfn :em :img :ins :kbd :q :s :samp :small :u
        :strike :strong :sub :sup :tt :b :form :tfoot
        :center :dl :dt :dd :ol :ul :li :fieldset :var
        :label :legend :table :caption :tbody :footer
        :thead :tr :th :td :article :aside :canvas :i
        :details :embed :figure :video :output :ruby
        :header :hgroup :menu :nav :figcaption :audio
        :section :summary :time :mark
        {:margin 0
         :padding 0
         :border 0
         :font-size "100%"
         :font "inherit"
         :vertical-align "baseline"}]

       [:article :aside :details :figcaption :figure
        :footer :header :hgroup :menu :nav :section
        {:display "block"}]

       [:body {:line-height 1}]

       [:ol :ul {:list-style "none"}]

       [:blockquote :q {:quotes "none"}]

       [:table {:border-collapse "collapse"
                :border-spacing 0}]

       [(blockquote before)
        (blockquote after)
        (q before)
        (q after)
        {:content "none"}]))
