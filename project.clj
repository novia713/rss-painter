(defproject paint-clj "0.1.0-SNAPSHOT"
  :description "experimento con gaseosa"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}


  :dependencies [[org.clojure/clojure "1.6.0"]
                 [jayq "2.5.4"]
                 [org.clojure/clojurescript "0.0-2268"]
                ]

  ;; lein-cljsbuild plugin to build a CLJS project
  :plugins [[lein-cljsbuild "1.0.4"]]

  :source-paths ["src/clj" "src/cljs"]



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
        :optimizations :whitespace
        :pretty-print true}}]})
