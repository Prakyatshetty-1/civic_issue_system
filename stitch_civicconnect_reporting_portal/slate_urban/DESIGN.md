# Design System Strategy: The Civic Monolith

## 1. Overview & Creative North Star
This design system is built upon the Creative North Star of **"The Civic Monolith."** 

Civic reporting software often suffers from a "bureaucratic aesthetic"—cluttered, rigid, and cold. The Civic Monolith pivots toward an authoritative, editorial experience. It treats civic data not as a series of rows in a database, but as a living record of a city’s health. We achieve this through **intentional asymmetry**, high-contrast typography scales, and a departure from the "boxed-in" layout. By utilizing overlapping surfaces and shifting tonal depths, we create a UI that feels architectural and permanent, yet fluid enough to handle the real-time nature of public service.

## 2. Colors & Surface Logic
The palette is rooted in deep, nocturnal blues and sophisticated slate tones, providing a low-strain environment for professional dispatchers and administrators.

### The "No-Line" Rule
To achieve a high-end, bespoke feel, **1px solid borders are strictly prohibited for sectioning.** Traditional SaaS UIs rely on borders to define space; this design system defines space through **Tonal Transitions**. 
*   Boundaries must be created by placing a `surface_container_high` element against a `surface_container_low` background. 
*   This creates a "soft edge" that feels integrated into the environment rather than a layer pasted on top.

### Surface Hierarchy & Nesting
Treat the dashboard as a physical stack of semi-matte materials. 
*   **Base Layer:** `surface_dim` (#0b1326) for the overall application background.
*   **Secondary Layer:** `surface_container_low` (#131b2e) for sidebar or navigation regions.
*   **Content Layer:** `surface_container` (#171f33) for the primary dashboard canvas.
*   **Active Elements:** `surface_container_highest` (#2d3449) for cards and modals.

### The Glass & Gradient Rule
For elements that require high prominence (e.g., an urgent incident report floating over the map), use **Glassmorphism**.
*   **Token:** `surface_variant` at 60% opacity with a 24px `backdrop-blur`.
*   **Signature Textures:** Use a subtle linear gradient on primary CTAs, transitioning from `primary_container` (#5b6f95) to `primary` (#b2c7f1) at a 135-degree angle. This adds a "visual soul" and metallic luster that flat colors lack.

## 3. Typography: The Editorial Voice
We use **Inter** not as a system font, but as a high-performance editorial tool.

*   **Display & Headline:** Use `display-md` (2.75rem) for high-impact metrics (e.g., total resolved issues). Set letter-spacing to `-0.02em` to give it a "tight," professional press look.
*   **Title:** `title-lg` (1.375rem) should be used for card headings to provide clear structural anchors.
*   **Body:** `body-md` (0.875rem) is the workhorse for issue descriptions. Ensure a line-height of `1.5` for maximum legibility in high-stress scenarios.
*   **Labels:** Use `label-sm` (0.6875rem) with `uppercase` styling and `0.05em` letter-spacing for metadata like "TIMESTAMPS" or "COORDINATES." This differentiates data from narrative text.

## 4. Elevation & Depth
In this design system, depth is a function of light and tone, not shadows.

*   **The Layering Principle:** Place a `surface_container_lowest` card on a `surface_container_low` section to create a "recessed" look for inactive data, while using `surface_container_highest` to "lift" active data.
*   **Ambient Shadows:** If a floating effect is required for a modal, use an extra-diffused shadow.
    *   **Shadow Color:** `on_surface` (#dae2fd) at 6% opacity.
    *   **Blur/Spread:** 40px blur, 0px spread. This mimics natural light dispersion.
*   **The "Ghost Border":** For accessibility in inputs, a border may be used. It must be an `outline_variant` (#44474e) at **15% opacity**. Never use 100% opaque borders.

## 5. Components

### Buttons & Interaction
*   **Primary:** A gradient-filled container (`primary_container` to `primary`) with `on_primary_container` text.
*   **Secondary:** No background. Use `on_surface` text with a "Ghost Border" that only appears on hover.
*   **Tertiary:** `tertiary_fixed` text for low-priority actions like "Cancel" or "Export."

### Civic Incident Cards
*   **Structure:** No dividers. Use `16px` vertical breathing room between the title and the metadata.
*   **Status Indicators:** Instead of large badges, use "Status Orbs." A 6px circular dot using the status tokens:
    *   **Open:** `error` (#ffb4ab)
    *   **In Progress:** `tertiary` (#d0bef6)
    *   **Resolved:** `on_tertiary_container` (#f8f0ff)

### Input Fields & Search
*   **Style:** `surface_container_lowest` background with a 1px "Ghost Border." 
*   **Focus State:** The border opacity increases to 40%, and a subtle `primary` outer glow (4px blur) is applied.

### Lists & Data Tables
*   **Rule:** Forbid divider lines. Use `surface_container_low` and `surface_container_high` alternating backgrounds (zebra striping) only if the data density is extreme. Otherwise, use whitespace and `body-sm` metadata to separate entries.

### Priority Pulse (Custom Component)
A high-end visualization for urgent civic issues. Use a `tertiary_container` glow effect behind the incident icon to create a "pulsing" animation, drawing the dispatcher’s eye without the use of harsh red flashes.

## 6. Do's and Don'ts

### Do
*   **Do** use `8px` grid multiples for all padding and margins to maintain structural rigor.
*   **Do** use `rounded-md` (0.75rem/12px) for large containers and `rounded-sm` (0.25rem/4px) for small interactive elements like checkboxes.
*   **Do** embrace negative space. If a dashboard feels "empty," increase the typography size of the headers rather than adding more boxes.

### Don't
*   **Don't** use pure black (#000000). Always use the `surface_dim` or `background` tokens to maintain the deep blue tonal depth.
*   **Don't** use standard "Success Green" for resolved issues if it clashes with the sophisticated palette; use the `on_tertiary_container` or `secondary` tokens to keep the UI professional and muted.
*   **Don't** use center-alignment for text in dashboards. Keep everything flush-left to maintain the "Editorial Monolith" structure.