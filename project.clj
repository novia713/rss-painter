(defproject paint-clj "0.1.0-SNAPSHOT"
  :description "experimento con gaseosa"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}


  :dependencies [[org.clojure/clojure "1.6.0"]
                 [jayq "2.5.4"]
                 [org.clojure/clojurescript "0.0-2268"]
                 [environ "1.0.0"]
                ]

  ;; lein-cljsbuild plugin to build a CLJS project
  :plugins [
      [lein-cljsbuild "1.0.4"]
      [lein-environ "1.0.0"]
      ]

  :source-paths ["src/clj" "src/cljs"]


  ;; app environment variables
  :env {
    :rss-uri "http://ajax.googleapis.com/ajax/services/feed/load?v=1.0&num=20&q=http://www.reddit.com/r/php/.rss"
  }


  ;; cljsbuild options configuration
  :cljsbuild {
   :builds [{;; CLJS source code path
    :source-paths ["src/cljs"]

      ;; Google Closure (CLS) options configuration
      :compiler {
        ;; CLS generated JS script filename
        :output-to "resources/public/js/modern.js"

        :externs ["externs/jquery-1.8.js"]


        ;; minimal JS optimization directive
        :optimizations :advanced
        ;:pretty-print true
        }}]})
