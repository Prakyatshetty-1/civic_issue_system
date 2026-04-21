# Design System Document

## 1. Overview & Creative North Star: "The Sovereign Ledger"

This design system is built for the high-stakes environment of civic infrastructure and public accountability. While the aesthetic is rooted in a conservative, internal tool ethos, we are moving beyond the generic "SaaS dashboard" look. 

The Creative North Star for this system is **"The Sovereign Ledger."** 

This concept treats data as a permanent, authoritative record. We achieve a premium feel through **Hyper-Dense Precision** and **Tonal Depth**. Instead of using boxes and lines to organize information, we use sophisticated layering and editorial-grade typography scales. The goal is to create an interface that feels like a heavy, well-organized physical ledger—utilizing intentional asymmetry and deep, ink-like navy tones to communicate stability and trust.

---

## 2. Colors & Tonal Architecture

In this system, color is not decorative; it is structural. We utilize a palette of deep blues and muted silvers to establish a professional, "quiet" atmosphere.

### The "No-Line" Rule
To achieve a signature high-end look, designers are prohibited from using 1px solid borders for sectioning or layout containment. Boundaries must be defined solely through background color shifts.
- A **Surface Container Low** (`#131b2e`) section should sit on the **Main Background** (`#0b1326`).
- A **Surface Container High** (`#222a3d`) card should sit within that section.
- This creates a "molded" look where the UI feels carved out of a single piece of material rather than a series of stickers.

### Surface Hierarchy & Nesting
Use the Material-inspired tiers to create physical depth:
1.  **Level 0 (Base):** `surface` (`#0b1326`) – The canvas.
2.  **Level 1 (Sections):** `surface_container_low` (`#131b2e`) – For large layout divisions.
3.  **Level 2 (Cards/Forms):** `surface_container` (`#171f33`) – Primary workspace.
4.  **Level 3 (Modals/Popovers):** `surface_container_highest` (`#2d3449`) – For elements requiring the most attention.

### Luminous Accents (Signature Textures)
While we avoid loud gradients, use **"Atmospheric Transitions."** For primary CTAs and active states, use a subtle linear gradient from `primary` (`#b2c7f1`) to `primary_container` (`#5b6f95`). This adds a sense of "finish" and professional polish that flat color cannot achieve, while remaining conservative.

---

## 3. Typography: Editorial Precision

We use **Inter** exclusively. To move away from "standard" UI, we use a high-contrast scale that prioritizes information density and clear hierarchy.

-   **Display (Editorial Hero):** Use `display-sm` (2.25rem) for main landing metrics. Set with a tight letter-spacing (-0.02em) to feel authoritative.
-   **Headline & Title (The Record):** Use `headline-sm` (1.5rem) for page titles. These should be paired with `secondary` text color (`#9ca3af`) for breadcrumbs to create an editorial "stack."
-   **Body (The Data):** `body-md` (0.875rem) is the workhorse. In dense tables, use `body-sm` (0.75rem) with a slightly increased line-height (1.5) to maintain legibility in high-density environments.
-   **Labels (The Metadata):** Use `label-sm` (0.6875rem) in **All Caps** with +0.05em tracking for form labels and table headers. This mimics the appearance of archival filing systems.

---

## 4. Elevation & Depth: Tonal Layering

Traditional shadows and thick borders are discarded in favor of **Tonal Layering.**

### The Layering Principle
Depth is achieved by "stacking" the surface tiers. A `surface_container_lowest` card placed on a `surface_container_low` section creates a soft, natural lift. This makes the layout feel integrated and "architectural."

### Ambient Shadows
If a "floating" element (like a context menu) is required, use a shadow with a 24px blur and only 4% opacity. The shadow color must be the `on_surface` color (`#dae2fd`) rather than black, creating a subtle "glow of depth" rather than a dark smudge.

### The "Ghost Border"
For input fields or areas requiring strict containment, use a **Ghost Border.** This is the `outline_variant` token (`#44474e`) at 20% opacity. This provides just enough visual friction for the eye without breaking the "No-Line" rule.

---

## 5. Component Guidelines

### Buttons: High-Density Actions
-   **Primary:** Solid `primary_container` (`#5b6f95`). Text is `on_primary_container` (`#eff2ff`). Radius: `lg` (0.5rem).
-   **Secondary:** Ghost style using the "Ghost Border" (20% opacity outline).
-   **States:** On hover, the background should shift one tier higher (e.g., from `primary_container` to `primary`).

### Tables: The Core Ledger
-   **No Divider Lines:** Separate rows using a subtle background hover state (`surface_container_low`). 
-   **Zebra Striping:** Use `surface_dim` for even rows and `surface_container_low` for odd rows.
-   **Headers:** Use `label-md` in All Caps with a background of `surface_container_high`.

### Forms: Dense Input
-   **Layout:** Labels should be top-aligned to the input, using `label-md` in `secondary` text color.
-   **Inputs:** Use `surface_container_lowest` for the input background to "set" it into the page.
-   **Focus State:** A 2px "Ghost Border" using the `tertiary` (`#d0bef6`) color at 40% opacity.

### Status Chips: Quiet Indicators
Do not use bright, saturated bubbles. Use a "Muted Signal" approach:
-   **Open:** Text `error` (`#ffb4ab`) with a 10% opacity background of the same color.
-   **Resolved:** Text `resolved` (`#16A34A`) with a 10% opacity background.
-   This ensures the status is readable but doesn't distract from the primary data.

---

## 6. Do's and Don'ts

### Do:
-   **Use Asymmetry:** Align primary content to a 12-column grid, but leave the far-right column empty for "breathing room" in dense layouts.
-   **Focus on Micro-Typography:** Pay extreme attention to letter spacing in labels and headers.
-   **Layer surfaces:** Always place a darker surface inside a lighter one to create an "inset" look for data entry.

### Don't:
-   **Don't use 100% white:** All text should be `on_surface` (`#dae2fd`) or `secondary` (`#9ca3af`) to maintain the "Dark Ledger" aesthetic.
-   **Don't use vertical lines:** In tables or forms, use white space and alignment to create columns, never vertical borders.
-   **Don't use "Glow" effects:** Keep the interface matte and professional. High-end tools don't need neon to show importance; they use hierarchy.