(ns com.wsscode.tailwind-garden.components.layout
  (:require [com.wsscode.tailwind-garden.defaults.responsive :as responsive]
            [garden.stylesheet]))

(def container
  "https://tailwindcss.com/docs/container"
  (into [[:.container {:width "100%"}]]
        (map (fn [[_name size]]
               (garden.stylesheet/at-media {:min-width size}
                 [:.container {:max-width size}])))
        responsive/breakpoints))

(def box-sizing
  "https://tailwindcss.com/docs/box-sizing"
  [[:.box-border {:box-sizing "border-box"}]
   [:.box-content {:box-sizing "content-box"}]])

(def display
  [[:.block {:display "block"}]
   [:.inline-block {:display "inline-block"}]
   [:.inline {:display "inline"}]
   [:.flex {:display "flex"}]
   [:.inline-flex {:display "inline-flex"}]
   [:.table {:display "table"}]
   [:.table-caption {:display "table-caption"}]
   [:.table-cell {:display "table-cell"}]
   [:.table-column {:display "table-column"}]
   [:.table-column-group {:display "table-column-group"}]
   [:.table-footer-group {:display "table-footer-group"}]
   [:.table-header-group {:display "table-header-group"}]
   [:.table-row-group {:display "table-row-group"}]
   [:.table-row {:display "table-row"}]
   [:.flow-root {:display "flow-root"}]
   [:.grid {:display "grid"}]
   [:.inline-grid {:display "inline-grid"}]
   [:.contents {:display "contents"}]
   [:.hidden {:display "none"}]])

(def overflow
  "https://tailwindcss.com/docs/overflow"
  [[:.overflow-auto {:overflow "auto"}]
   [:.overflow-hidden {:overflow "hidden"}]
   [:.overflow-visible {:overflow "visible"}]
   [:.overflow-scroll {:overflow "scroll"}]
   [:.overflow-x-auto {:overflow-x "auto"}]
   [:.overflow-y-auto {:overflow-y "auto"}]
   [:.overflow-x-hidden {:overflow-x "hidden"}]
   [:.overflow-y-hidden {:overflow-y "hidden"}]
   [:.overflow-x-visible {:overflow-x "visible"}]
   [:.overflow-y-visible {:overflow-y "visible"}]
   [:.overflow-x-scroll {:overflow-x "scroll"}]
   [:.overflow-y-scroll {:overflow-y "scroll"}]])
