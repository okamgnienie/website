(set-env!
 :source-paths #{"src/clj" "src/cljs"}
 :resource-paths #{"resources"}
 :dependencies '[[adzerk/boot-cljs "2.0.0" :scope "test"]
                 [adzerk/boot-cljs-repl "0.3.3" :scope "test"]
                 [adzerk/boot-reload "0.5.1" :scope "test"]
                 [pandeiro/boot-http "0.8.3" :scope "test"]
                 [com.cemerick/piggieback "0.2.1" :scope "test"]
                 [org.clojure/tools.nrepl "0.2.13" :scope "test"]
                 [org.clojure/clojurescript "1.9.562"]
                 [org.martinklepsch/boot-garden "1.3.2-0"]
                 [weasel "0.7.0" :scope "test"]
                 [reagent "0.6.0"]
                 [re-frame "0.9.1"]
                 [secretary "1.2.3"]])

(require
 '[adzerk.boot-cljs :refer [cljs]]
 '[adzerk.boot-cljs-repl :refer [cljs-repl start-repl]]
 '[adzerk.boot-reload :refer [reload]]
 '[pandeiro.boot-http :refer [serve]]
 '[org.martinklepsch.boot-garden :refer [garden]])

(deftask build []
  (comp (speak)
        (cljs)
        (garden :styles-var 'website.styles/all
                :vendors ["moz" "webkit" "o"]
                :output-to "css/styles.css")))

(deftask production []
  (task-options! cljs {:optimizations :advanced}
                 garden {:pretty-print false})
  identity)

(deftask development []
  (task-options! cljs {:optimizations :none}
                 garden {:pretty-print true}
                 reload {:on-jsload 'website.app/init})
  identity)

(deftask dev []
  (comp (development)
        (serve)
        (watch)
        (cljs-repl)
        (reload)
        (build)))

(deftask pro []
  (comp (production)
        (build)
        (target)))
